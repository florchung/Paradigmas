module Prompter (Prompter, nuevoP, archivosR, departamentosP, configurarP, anunciosP, showP, avanzarP, duracionP)
    where

import Tipos
import Anuncio
import FileSystem


--'Prompter' mantiene un 'FileSystem', la lista de departamentos configurados y un índice para la reproducción de anuncios.
data Prompter = Pro FileSystem [Departamento] Int deriving (Eq, Show)

--Crea un nuevo 'Prompter' a partir de un 'FileSystem', sin departamentos configurados y con el índice en 0.
nuevoP :: FileSystem -> Prompter
nuevoP fs = Pro fs [] 0

--Devuelve el 'FileSystem' asociado a un 'Prompter'.
archivosR :: Prompter -> FileSystem
archivosR (Pro fs _ _) = fs

--Devuelve la lista de departamentos configurados en un 'Prompter'.
departamentosP :: Prompter -> [Departamento]
departamentosP (Pro _ deps _) = deps

--Prepara el 'Prompter' para emitir anuncios en los departamentos indicados.
configurarP :: Prompter -> [Departamento] -> Prompter
configurarP (Pro fs _ idx) deps = Pro fs deps idx

--Devuelve la lista de nombres de los anuncios configurados en el 'Prompter'.
anunciosP :: Prompter -> [Nombre]
anunciosP (Pro fs deps _) = map nombreA (anunciosParaF deps fs)

--Muestra el anuncio actual en la lista configurada.
showP :: Prompter -> Anuncio
showP (Pro fs deps idx) = (anunciosParaF deps fs) !! idx

--Pasa al siguiente anuncio en la lista, de forma cíclica.
avanzarP :: Prompter -> Prompter
avanzarP (Pro fs deps idx) = Pro fs deps ((idx + 1) `mod` length (anunciosParaF deps fs))

--Devuelve la duración total de los anuncios configurados.
duracionP :: Prompter -> Duracion
duracionP (Pro fs deps _) = sum (map duracionA (anunciosParaF deps fs))
