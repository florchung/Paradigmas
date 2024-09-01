module Prompter (Prompter, nuevoP, archivosR, departamentosP, configurarP, anunciosP, showP, avanzarP, duracionP)
    where

import Tipos
import Anuncio
import FileSystem

-- Definición del tipo de dato Prompter.
-- Un Prompter contiene un FileSystem, una lista de departamentos, y un índice actual.
data Prompter = Pro FileSystem [Departamento] Int deriving (Eq, Show)

-- Crea un nuevo Prompter dado un FileSystem.
-- Inicializa el Prompter con todos los departamentos del FileSystem y un índice inicial de 0.
nuevoP :: FileSystem -> Prompter
nuevoP fs = Pro fs (departamentosF fs) 0

-- Obtiene el FileSystem asociado a un Prompter.
archivosR :: Prompter -> FileSystem
archivosR (Pro fs _ _) = fs

-- Obtiene la lista de departamentos asociados a un Prompter.
departamentosP :: Prompter -> [Departamento]
departamentosP (Pro _ deps _) = deps

-- Configura un nuevo conjunto de departamentos para un Prompter.
-- Actualiza el Prompter con los nuevos departamentos, manteniendo el mismo índice.
configurarP :: Prompter -> [Departamento] -> Prompter
configurarP (Pro fs _ idx) deps = Pro fs deps idx

-- Obtiene la lista de nombres de anuncios que aplican para los departamentos actuales del Prompter.
-- Usa la función `anunciosParaF` del FileSystem para filtrar los anuncios por los departamentos configurados.
anunciosP :: Prompter -> [Nombre]
anunciosP (Pro fs deps _) = map nombreA (anunciosParaF deps fs)

-- Muestra el anuncio actual según el índice.
-- Si el índice está fuera de rango o no hay anuncios aplicables, devuelve Nothing.
-- De lo contrario, devuelve el anuncio correspondiente en el índice.
showP :: Prompter -> Maybe Anuncio
showP (Pro fs deps idx)
  | null anuncios = Nothing
  | otherwise = Just (anuncios !! idx)
  where
    anuncios = anunciosParaF deps fs

-- Avanza al siguiente anuncio en la lista de anuncios aplicables.
-- Incrementa el índice actual y lo ajusta con `mod` para que sea circular.
avanzarP :: Prompter -> Prompter
avanzarP (Pro fs deps idx) = Pro fs deps ((idx + 1) `mod` length anuncios)
  where anuncios = anunciosParaF deps fs

-- Calcula la duración total de todos los anuncios aplicables según los departamentos del Prompter.
-- Suma las duraciones de los anuncios filtrados.
duracionP :: Prompter -> Duracion
duracionP (Pro fs deps _) = sum (map duracionA (anunciosParaF deps fs))
