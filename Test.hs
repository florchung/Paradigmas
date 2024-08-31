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
tAnuncios = [ testF (nuevoA "" 0),
              nombreA a1 == "anuncio1",
              duracionA a1 == 10,
              departamentosA a1 == [],
              departamentosA (agregarA "dep1" a1) == ["dep1"],
              departamentosA (sacarA "dep1" (agregarA "dep1" a1)) == [],
              aplicaA ["dep1"] (agregarA "dep1" a1),
              not (aplicaA ["dep2"] a1)
            ]

-- Pruebas de FileSystem
tFileSystem = [ testF (nuevoF), -- Verifica que no se lanza una excepción al crear un nuevo FileSystem
                -- Test para agregar anuncios
                departamentosF fs4 == [],
                anunciosF fs4 == [a1, a2, a3],
                anunciosF (sacarAnuncioF a1 fs4) == [a2, a3],
                -- Test para agregar y sacar departamentos
                testF (agregarDepartamentoF "dep1" fs4),
                testF (sacarDepartamentoF "dep1" (agregarDepartamentoF "dep1" fs4)),
                -- Test para anuncios por departamento
                anunciosParaF ["dep1"] (agregarDepartamentoF "dep1" fs4) == [],
                anunciosParaF [] fs4 == [a1, a2, a3]
              ]

-- Pruebas de Prompter
tPrompter = [ testF (nuevoP fs4),
              departamentosP (configurarP p1 ["dep1", "dep2"]) == ["dep1", "dep2"],
              anunciosP p2 == ["anuncio1", "anuncio2", "anuncio3"],
              maybe False (== a1) (showP (configurarP p1 ["dep1"])),
              anunciosP (avanzarP p2) == ["anuncio1", "anuncio2", "anuncio3"],
              duracionP p2 == (duracionA a1 + duracionA a2 + duracionA a3)
            ]

-- Ejecutar todas las pruebas y mostrar resultados
main :: IO ()
main = do
    putStrLn "Pruebas de Anuncio:"
    mapM_ print tAnuncios
    putStrLn "Pruebas de FileSystem:"
    mapM_ print tFileSystem
    putStrLn "Pruebas de Prompter:"
    mapM_ print tPrompter
