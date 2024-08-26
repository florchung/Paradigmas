module FileSystem (nuevoF, departamentoF, anunciosF, agregarAnuncioF, sacarAnuncioF, agregarDepartamentoF, sacarDepartamentoF, anunciosParaF)
  where

import Tipos
import Anuncio

data FileSystem = FS [Departamento] [Anuncio] deriving (Eq, Show)

nuevoF :: FileSystem
nuevoF = FS [] []

departamentosF :: FileSystem -> [Departamento]
departamentosF (FS deps _) = deps

anunciosF :: FileSystem -> [Anuncio]
anunciosF (FS _ anuncios) = anuncios

agregarAnuncioF :: Anuncio -> FileSystem -> FileSystem
agregarAnuncioF anuncio (FS deps anuncios) = FS deps (anuncio : anuncios)

sacarAnuncioF :: Anuncio -> FileSystem -> FileSystem
sacarAnuncioF anuncio (FS deps anuncios) = FS deps (filter (/= anuncio) anuncios)

agregarDepartamentoF :: Departamento -> FileSystem -> FileSystem
agregarDepartamentoF dep (FS deps anuncios) =
    if dep `elem` deps 
    then FS deps anuncios 
    else FS (dep : deps) anuncios

sacarDepartamentoF :: Departamento -> FileSystem -> FileSystem
sacarDepartamentoF dep (FS deps anuncios) = FS (filter (/= dep) deps) anuncios

anunciosParaF :: [Departamento] -> FileSystem -> [Anuncio]
anunciosParaF deps (FS _ anuncios) = filter (aplicaA deps) anuncios
