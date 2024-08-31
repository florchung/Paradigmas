module Prompter (Prompter, nuevoP, archivosR, departamentosP, configurarP, anunciosP, showP, avanzarP, duracionP)
    where

import Tipos
import Anuncio
import FileSystem

data Prompter = Pro FileSystem [Departamento] Int deriving (Eq, Show)

nuevoP :: FileSystem -> Prompter
nuevoP fs = Pro fs (departamentosF fs) 0

archivosR :: Prompter -> FileSystem
archivosR (Pro fs _ _) = fs

departamentosP :: Prompter -> [Departamento]
departamentosP (Pro _ deps _) = deps

configurarP :: Prompter -> [Departamento] -> Prompter
configurarP (Pro fs _ idx) deps = Pro fs deps idx

anunciosP :: Prompter -> [Nombre]
anunciosP (Pro fs deps _) = map nombreA (anunciosParaF deps fs)

showP :: Prompter -> Maybe Anuncio
showP (Pro fs deps idx)
  | null anuncios = Nothing
  | otherwise = Just (anuncios !! idx)
  where
    anuncios = anunciosParaF deps fs

avanzarP :: Prompter -> Prompter
avanzarP (Pro fs deps idx) = Pro fs deps ((idx + 1) `mod` length anuncios)
  where anuncios = anunciosParaF deps fs

duracionP :: Prompter -> Duracion
duracionP (Pro fs deps _) = sum (map duracionA (anunciosParaF deps fs))
