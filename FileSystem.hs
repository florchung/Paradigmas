module FileSystem ( FileSystem, nuevoF, departamentosF, anunciosF, agregarAnuncioF, sacarAnuncioF, agregarDepartamentoF, sacarDepartamentoF, anunciosParaF )
    where

import Tipos
import Anuncio

data FileSystem = FS [Departamento] [Anuncio] deriving (Eq, Show)
b= (agregarA "jorge" (nuevoA "mi" 21))
c= (agregarA "jorge" (nuevoA "hola" 33))
d= (agregarA "no" (nuevoA "chau" 2))
nuevoF :: FileSystem                                              -- permite obtener un nuevo FileSystem
nuevoF = (FS [] [] )

departamentosF :: FileSystem -> [ Departamento ]                  -- dado un FileSystem retorna los departamentos que incluye
departamentosF (FS [departamento] [anuncio]) = [departamento]

anunciosF :: FileSystem -> [ Anuncio ]                            -- dado un FileSystem retorna los anuncios que incluye
anunciosF (FS [departamento] [anuncio]) = [anuncio]

agregarAnuncioF :: Anuncio -> FileSystem -> FileSystem            -- permite agregar un anuncio  
agregarAnuncioF anuncio (FS _ anuncios) | (elem anuncio anuncios) == False = (FS _ (anuncio:anuncios))
                                        | True = (FS _ anuncios)

sacarAnuncioF :: Anuncio -> FileSystem -> FileSystem              -- permite eliminar un anuncio
sacarAnuncioF anuncio (FS _ anuncios) = (FS _ anuncios2)
                                               where anuncios2 = [anun|anun<-anuncios, anun/=anuncio]
              
agregarDepartamentoF :: Departamento -> FileSystem -> FileSystem  -- permite agregar un departamento
agregarDepartamentoF depto (FS departamentos anuncios) 

sacarDepartamentoF :: Departamento -> FileSystem -> FileSystem    -- permite eliminar un departamento
sacarDepartamentoF depto (FS departamentos anuncios) 

anunciosParaF :: [Departamento] -> FileSystem -> [Anuncio]        -- entrega los anuncios a emitir para un conjunto de departamentos
anunciosParaF departamentos (FS _ anuncios) = [anuncio|anuncio<-anuncios, (aplicaA departamentos anuncio)]
