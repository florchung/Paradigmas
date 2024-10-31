package explorer;

public class Explorer {
    public Coordenadas coordenadas;
    public Cardinal cardinal;
    public String NO_PUEDEN_HABER_DOS_ESCOTILLAS_ABIERTAS_AL_MISMO_TIEMPO="No pueden haber dos escotillas abiertas al mismo tiempo";
    public String LA_ESCOTILLA_YA_ESTA_ABIERTA="La escotilla ya esta abierta";
    public String PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_SUPERIOR="Primero tiene que abrir la escotilla superior";
    public String PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_INFERIOR="Primero tiene que abrir la escotilla inferior";
    public String NO_HAY_NINGUNA_ESCOTILLA_ABIERTA="No hay ninguna escotilla abierta";
    protected boolean escotillaSuperiorAbierta = false;
    protected boolean escotillaInferiorAbierta = false;

    public Explorer(Coordenadas coordenadas, Cardinal cardinal) {
        this.coordenadas = coordenadas;
        this.cardinal = cardinal;
    }
    public String getDireccion() {
        return cardinal.direccion();
    }
    public Coordenadas getPosition(){
        return coordenadas.puntoActual();
    }
    public void comandar(char operacion) {
        (Comando.tomarOrden(operacion)).accion(this);

//        if (operacion=='f'){
//            avanzar();
//            //comando.trabajar(this);
//        }
//        if (operacion=='b'){
//            retroceder();
//        }
//        if (operacion == 'l') {
//            turnLeft();
//        }
//        if (operacion=='r'){
//            turnright();
//        }
//        if (operacion=='O'){
//            abrirEscotillaSuperior();
//        }
//        if(operacion=='o'){
//            abrirEscotillaInferior();
//        }
//        if(operacion=='c'){
//            cerrarEscotilla();
//        }
//        if(operacion=='a'){
//            aspirar();
//        }
//        if (operacion=='i'){
//            recolectarMuestras();
//        }
//        throw new RuntimeException("Comando "+operacion+" no detectado");
    }
    public void turnright() {
        cardinal.girarDerecha(this);
    }
    public void retroceder() {
        cardinal.recular(this);
    }
    public void turnLeft() {
        cardinal.girarIzquierda(this);
    }
    public void avanzar() {
        cardinal.marchar(this);
    }
    public void abrirEscotillaSuperior(){
        if(escotillaInferiorAbierta ==true){
            throw new RuntimeException(NO_PUEDEN_HABER_DOS_ESCOTILLAS_ABIERTAS_AL_MISMO_TIEMPO);
        }
        if(escotillaSuperiorAbierta ==true){
            throw new RuntimeException(LA_ESCOTILLA_YA_ESTA_ABIERTA);
        }
        escotillaSuperiorAbierta = true;
    }

    public void abrirEscotillaInferior(){
        if(escotillaSuperiorAbierta ==true){
            throw new RuntimeException(NO_PUEDEN_HABER_DOS_ESCOTILLAS_ABIERTAS_AL_MISMO_TIEMPO);
        }
        if(escotillaInferiorAbierta ==true){
            throw new RuntimeException(LA_ESCOTILLA_YA_ESTA_ABIERTA);
        }
        escotillaInferiorAbierta = true;
    }

    public void cerrarEscotilla(){
        if(escotillaSuperiorAbierta ==true){
            escotillaSuperiorAbierta = false;
        }
        if(escotillaInferiorAbierta ==true){
            escotillaInferiorAbierta = false;
        }
        else if(escotillaSuperiorAbierta ==false && escotillaInferiorAbierta == false){
            throw new RuntimeException(NO_HAY_NINGUNA_ESCOTILLA_ABIERTA);
        }
    }
    public void aspirar(){
        if(escotillaSuperiorAbierta ==false){
            throw new RuntimeException(PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_SUPERIOR);
        }
    }
    public void recolectarMuestras(){
        if(escotillaInferiorAbierta ==false){
            throw new RuntimeException(PRIMERO_TIENE_QUE_ABRIR_LA_ESCOTILLA_INFERIOR);
        }
    }

    public void ordenar(String ordenes){
        //Preguntar como polimorfizar comandar
        ordenes.chars().forEach(charascii->comandar((char) charascii));
    }
}
