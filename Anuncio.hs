import Tipos

data Anuncio = Anu Nombre [ Departamento ] Duracion deriving (Eq, Show, Ord)

nuevoA :: Nombre -> Duracion -> Anuncio         -- dado un nombre y una duracion en segundos retorna un nuevo Anuncio
nuevoA nombre duracion = Anu nombre [""] duracion
nombreA :: Anuncio -> Nombre                    -- dado un anuncio retorna su nombre
nombreA (Anu nombre [departamentos] duracion) = nombre
duracionA :: Anuncio -> Duracion                -- dado un anuncio retorna su duración
duracionA (Anu nombre [departamentos] duracion) = duracion
departamentosA :: Anuncio -> [ Departamento ]   -- dado un anuncio retorna los departamentos que le fueron asociados
departamentosA (Anu nombre [departamentos] duracion) = [departamentos]
agregarA :: Departamento -> Anuncio -> Anuncio -- permite asignar un departamento a un anuncio
agregarA departamento (Anu nombre [departamentos] duracion) | (elem departamento (departamentosA (Anu nombre [departamentos] duracion)) ) = (Anu nombre [departamentos] duracion)
                                                            | otherwise =(Anu nombre [departamentos]++[departamento] duracion)
--sacarA :: Departamento -> Anuncio -> Anuncio    -- permite quitarle un departamento a un anuncio
--aplicaA :: [ Departamento ] -> Anuncio -> Bool  -- responde si un anuncion debe emitirse para alguno de los departamentos consultados