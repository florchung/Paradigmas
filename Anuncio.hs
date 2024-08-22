import Tipos

data Anuncio = Anu Nombre [ Departamento ] Duracion deriving (Eq, Show, Ord)

nuevoA :: Nombre -> Duracion -> Anuncio         -- dado un nombre y una duracion en segundos retorna un nuevo Anuncio
nuevoA nombre duracion = Anu nombre [] duracion
nombreA :: Anuncio -> Nombre                    -- dado un anuncio retorna su nombre
nombreA (Anu nombre xs duracion) = nombre
duracionA :: Anuncio -> Duracion                -- dado un anuncio retorna su duración
duracionA (Anu nombre xs duracion) = duracion
departamentosA :: Anuncio -> [ Departamento ]   -- dado un anuncio retorna los departamentos que le fueron asociados
departamentosA (Anu nombre xs duracion) = xs
agregarA :: Departamento -> Anuncio -> Anuncio -- permite asignar un departamento a un anuncio
agregarA departamento (Anu nombre xs duracion) = (Anu nombre (xs++ys) duracion)
                                                  where ys = [y|y <- [departamento] , (elem departamento xs)==False]
sacarA :: Departamento -> Anuncio -> Anuncio    -- permite quitarle un departamento a un anuncio
sacarA departamento (Anu nombre xs duracion) = (Anu nombre ys duracion)
                                               where ys = [x|x<-xs, x/=departamento]
aplicaA :: [ Departamento ] -> Anuncio -> Bool  -- responde si un anuncion debe emitirse para alguno de los departamentos consultados
aplicaA xs (Anu nombre ys duracion) = (length zs) == (length xs)
     where zs = [z|z<-xs,(elem z ys)==True]
