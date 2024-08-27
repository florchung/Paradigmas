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

agregarAnuncioF :: Anuncio -> FileSystem -> FileSystem
agregarAnuncioF (Anu nombre anuncioDeps duracion) (FS departamentos anuncios)
  | any (`notElem` departamentos) anuncioDeps = error "Uno o más departamentos del anuncio no están en el FileSystem"
  | Anu nombre anuncioDeps duracion `elem` anuncios = error "El anuncio ya está en el FileSystem"
  | otherwise = FS (foldr (\dep acc -> if dep `elem` acc then acc else dep:acc) departamentos anuncioDeps) (Anu nombre anuncioDeps duracion : anuncios)

sacarAnuncioF :: Anuncio -> FileSystem -> FileSystem
sacarAnuncioF anuncio (FS departamentos anuncios)
  | not (elem anuncio anuncios) = error "El anuncio no existe en el FileSystem"
  | otherwise = FS departamentos [anun | anun <- anuncios, anun /= anuncio]
              
agregarDepartamentoF :: Departamento -> FileSystem -> FileSystem
agregarDepartamentoF depto (FS departamentos anuncios)
  | depto `elem` departamentos = error "El departamento ya existe en el FileSystem"
  | otherwise = FS (depto:departamentos) anuncios

sacarDepartamentoF :: Departamento -> FileSystem -> FileSystem
sacarDepartamentoF depto (FS departamentos anuncios)
  | depto `notElem` departamentos = error "El departamento no existe en el FileSystem"
  | otherwise = FS [d | d <- departamentos, d /= depto] anuncios

anunciosParaF :: [Departamento] -> FileSystem -> [Anuncio]
anunciosParaF departamentos (FS fsDeps anuncios)
  | null anuncios = [] -- no hay anuncios en FS, devuelve lista vacia
  | null validDeps = error "No existen anuncios para los departamentos dados, ni otros departamentos en el sistema"
  | otherwise = anunciosValidos -- devuelve los anuncios validos para los departamentos filtrados
  where
    validDeps = filter (`elem` fsDeps) departamentos
    anunciosValidos = filter (aplicaA validDeps) anuncios

