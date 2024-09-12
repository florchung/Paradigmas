import Tipos
import Anuncio
import FileSystem
import Prompter
import Control.Exception
import System.IO.Unsafe


-- Función para verificar si una acción lanza una excepción
testF :: Show a => a -> Bool
testF action = unsafePerformIO $ do
    result <- tryJust isException (evaluate action)
    return $ case result of
        Left _ -> True
        Right _ -> False
    where
        isException :: SomeException -> Maybe ()
        isException _ = Just ()

-- Creación de anuncios para las pruebas
a1 = nuevoA "anuncio1" 10
a2 = nuevoA "anuncio2" 20
a3 = nuevoA "anuncio3" 30

-- Crear un FileSystem y agregar anuncios
fs4 = agregarAnuncioF a1 (agregarAnuncioF a2 (agregarAnuncioF a3 nuevoF))

-- Creación de un Prompter para las pruebas
p1 = nuevoP fs4
p2 = configurarP p1 ["dep1", "dep2"]

-- Pruebas de Anuncio
tAnuncios = [ 
    -- Verifica que la creacion de un anuncio con nombre vacio y duracion 0 no lanza excepcion
    testF (nuevoA "" 0),

    -- Verifica que el nombre de a1 sea 'anuncio1', es decir, si retorna bien su nombre.
    nombreA a1 == "anuncio1",

    -- Verifica que la duracion de a1 sea 10, es decir, si retorna bien su duracion.
    duracionA a1 == 10,

    -- Verifica los departamentos asociados a un anuncio, en este caso de a1
    departamentosA a1 == [],

    -- Verifica que se haya agregado bien un departamento asociado a un anuncio
    departamentosA (agregarA "dep1" a1) == ["dep1"],

    -- Verifica que se haya sacado bien un departamento de un anuncio
    departamentosA (sacarA "dep1" (agregarA "dep1" a1)) == [],

    -- Verifica que el anuncio aplique correctamente para un departamento
    aplicaA ["dep1"] (agregarA "dep1" a1),
    
    -- Verifica que el anuncio no aplique para un departamento
    not (aplicaA ["dep2"] a1)
            ]

tFileSystem = [
    -- Verifica que al crear un nuevo FileSystem, inicialmente no hay departamentos
    departamentosF (nuevoF) == [],

    -- Verifica que fs4 no tiene departamentos al inicio, al mismo esto verifica la creacion del FS
    departamentosF fs4 == [],

    -- Verifica que fs4 tiene los anuncios correctos
    anunciosF fs4 == [a1, a2, a3],

    -- Verifica que después de sacar a1, quedan a2 y a3
    anunciosF (sacarAnuncioF a1 fs4) == [a2, a3],

    -- Verifica que no se lanza una excepción al agregar un departamento
    departamentosF (agregarDepartamentoF "dep1" fs4) == ["dep1"],

    -- Verifica que no se lanza una excepción al sacar un departamento
    departamentosF (sacarDepartamentoF "dep1" (agregarDepartamentoF "dep1" fs4)) == [],

    -- Verifica que no hay anuncios para "dep1"
    anunciosParaF ["dep1"] (agregarDepartamentoF "dep1" fs4) == [],

    -- Verifica que sin departamentos, se devuelven todos los anuncios
    anunciosParaF [] fs4 == [a1, a2, a3]
    ]

-- Pruebas de Prompter
tPrompter = [ 
    -- Verifica que no se lanza una excepción al crear un nuevo Prompter
    departamentosP (nuevoP fs4) == [],

    -- Verifica que se configuran correctamente los departamentos en el Prompter
    departamentosP (configurarP p1 ["dep1", "dep2"]) == ["dep1", "dep2"],

    -- Verifica que se obtienen correctamente los nombres de los anuncios según los departamentos configurados, en este caso con p2
    anunciosP p2 == ["anuncio1","anuncio2","anuncio3"],
              
    -- Verifica que se muestra el primer anuncio cuando se configura con un solo departamento
    maybe False (== a1) (showP (configurarP p1 ["dep1"])),

    -- Verifica que al avanzar, los anuncios permanecen consistentes
    anunciosP (avanzarP p2) == ["anuncio1","anuncio2","anuncio3"],

    -- Verifica que la duración total calculada es correcta, en este caso, la suma de la duracion de los anuncios a1, a2 y a3
    duracionP p2 == 60
    ]

-- Ejecutar todas las pruebas y mostrar resultados, imprime los resultados
main :: IO ()
main = do
    putStrLn "Pruebas de Anuncio:"
    mapM_ print tAnuncios
    putStrLn "Pruebas de FileSystem:"
    mapM_ print tFileSystem
    putStrLn "Pruebas de Prompter:"
    mapM_ print tPrompter
