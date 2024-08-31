module FileSystem ( FileSystem, nuevoF, departamentosF, anunciosF, agregarAnuncioF, sacarAnuncioF, agregarDepartamentoF, sacarDepartamentoF, anunciosParaF )
    where

import Tipos
import Anuncio

data FileSystem = FS [Departamento] [Anuncio] deriving (Eq, Show)
b= (agregarA "jorge" (nuevoA "mi" 21))
c= (agregarA "jorge" (nuevoA "hola" 33))
d= (agregarA "no" (nuevoA "chau" 2))

insertar ::Ord a =>  a -> [a] -> [a]
insertar a [] = [a]
insertar a (x:xs)
    | a < x = a : (x : xs)
    | a == x  = x:xs
    | otherwise = x : insertar a xs

nuevoF :: FileSystem                                              -- permite obtener un nuevo FileSystem
nuevoF = (FS [] [] )

departamentosF :: FileSystem -> [ Departamento ]                  -- dado un FileSystem retorna los departamentos que incluye
departamentosF (FS departamento anuncio) = departamento

anunciosF :: FileSystem -> [ Anuncio ]                            -- dado un FileSystem retorna los anuncios que incluye
anunciosF (FS departamento anuncio) = anuncio

agregarAnuncioF :: Anuncio -> FileSystem -> FileSystem
agregarAnuncioF anuncio (FS departamentos anuncios ) =  FS  depts (insertar anuncio  anuncios)
    where depts = foldr (insertar) departamentos (departamentosA anuncio)

sacarAnuncioF :: Anuncio -> FileSystem -> FileSystem
sacarAnuncioF anuncio (FS departamentos anuncios)
  | not (elem anuncio anuncios) = error "El anuncio no existe en el FileSystem"
  | otherwise = FS departamentos [anun | anun <- anuncios, anun /= anuncio]

agregarDepartamentoF :: Departamento -> FileSystem -> FileSystem
agregarDepartamentoF depto (FS departamentos anuncios)
  | elem depto departamentos = error "El departamento ya existe en el FileSystem"
  | otherwise = FS (insertar depto departamentos) anuncios

sacarDepartamentoF :: Departamento -> FileSystem -> FileSystem
sacarDepartamentoF depto (FS departamentos anuncios)
  | not (elem depto departamentos) = error "El departamento no existe en el FileSystem"
  | otherwise = FS [d | d <- departamentos, d /= depto] anuncios

anunciosParaF :: [Departamento] -> FileSystem -> [Anuncio]
anunciosParaF departamentos (FS fsDeps anuncios)
  | null anuncios = [] -- no hay anuncios en FS, devuelve lista vacia
  | null validDeps = error "No existen anuncios para los departamentos dados, ni otros departamentos en el sistema"
  | otherwise = anunciosValidos -- devuelve los anuncios validos para los departamentos filtrados
  where
    validDeps = filter (`elem` fsDeps) departamentos
    anunciosValidos = filter (aplicaA validDeps) anuncios

