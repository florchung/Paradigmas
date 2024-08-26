module Anuncio ( Anuncio, nuevoA, nombreA, duracionA, departamentosA, agregarA, sacarA, aplicaA )
  where

import Tipos

data Anuncio = Anu Nombre [ Departamento ] Duracion deriving (Eq, Show, Ord)

nuevoA :: Nombre -> Duracion -> Anuncio         -- dado un nombre y una duracion en segundos retorna un nuevo Anuncio
nuevoA nombre duracion = Anu nombre [] duracion

nombreA :: Anuncio -> Nombre                    -- dado un anuncio retorna su nombre
nombreA (Anu nombre deps duracion) = nombre

duracionA :: Anuncio -> Duracion                -- dado un anuncio retorna su duración
duracionA (Anu nombre deps duracion) = duracion

departamentosA :: Anuncio -> [ Departamento ]   -- dado un anuncio retorna los departamentos que le fueron asociados
departamentosA (Anu nombre deps duracion) = deps

agregarA :: Departamento -> Anuncio -> Anuncio -- permite asignar un departamento a un anuncio
agregarA departamento (Anu nombre deps duracion) = (Anu nombre (deps++deps2) duracion)
     where deps2 = [depto|depto <- [departamento] , (elem departamento deps)==False]

sacarA :: Departamento -> Anuncio -> Anuncio    -- permite quitarle un departamento a un anuncio
sacarA departamento (Anu nombre deps duracion) = (Anu nombre departamento duracion)
     where departamento = [depto|depto<-deps, depto/=departamento]

aplicaA :: [ Departamento ] -> Anuncio -> Bool  -- responde si un anuncion debe emitirse para alguno de los departamentos consultados
aplicaA deps (Anu nombre departamento duracion) = (length depto) == (length deps)
     where depto = [depto|depto<-deps,(elem depto departamento)==True]
