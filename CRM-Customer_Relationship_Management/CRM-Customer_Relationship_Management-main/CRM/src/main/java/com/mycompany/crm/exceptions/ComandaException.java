package com.mycompany.crm.exceptions;


import java.util.Arrays;
import java.util.List;

public class ComandaException  extends Exception{

   public static final int ERROR_DNI = 0;
   public static final int ERROR_TEL = 1;
   public static final int ERROR_CORREO = 2;
   public static final int ERROR_NOM = 3;
   public static final int ERROR_AP = 4;
   public static final int CLIENTE_EXISTE = 5;
   public static final int EMPLEADO_EXISTE = 6;
   public static final int NO_CLIENTES = 7;
   public static final int NO_EMPLEADOS = 8;
   public static final int DATO_INCORRECTO = 9;
   public static final int ERROR_USER = 10;
   public static final int NOEXISTE_EMPLEADO = 11;
   public static final int NOEXISTE_CLIENTE = 12;
   public static final int ARGS_INCORRECTOS = 13;
   public static final int NO_DATO = 14;
   public static final int DOS_APELLIDOS = 15;
   public static final int MAX_NOMBRES = 16;
   public static final int ERROR_CONTRASEÑA = 17;
   public static final int ERROR_CP = 18;
   public static final int ERROR_FECHA = 19;
    public static final int ERROR_SQL = 20;
   public static final int ERROR_PERMISOS = 21;
    public static final int ERROR_LONGITUD_45 = 22;
    public static final int ERROR_LONGITUD_65 = 23;
    public static final int ERROR_LONGITUD_255 = 24;
    public static final int ERROR_ELIMANAR_CON_ACCIONES = 25;
    public static final int ERROR_COMISION_FORMATO = 26;
    public static final int ERROR_RANGO_FECHAINCORPORACION = 27;
    public static final int ERROR_LONGITUD_100 = 28;
    public static final int ERROR_LONGITUD_9 = 29;
    public static final int ERROR_LONGITUD_60 = 30;
    public static final int ERROR_NUM_ENTERO = 31;








    private final List<String> mensajes = Arrays.asList (
           "ERROR: EL FORMATO DEL DNI DEBE SER '12345678X'",
           "ERROR: NUMERO DE TELEFONO INVALIDO. EL NÚMERO DEBE TENER 9 DÍGITOS SIN ESPACIOS",
           "ERROR: CORREO INVALIDO",
           "ERROR: NOMBRE INVALIDO",
           "ERROR: APELLIDO INVALIDO",
           "ERROR: EL CLIENTE YA SE ENCUENTRA EN LA BASE DE DATOS",
           "ERROR: EL EMPLEADO YA SE ENCUENTRA EN LA BASE DE DATOS",
           "ERROR: NO EXISTEN CLIENTES",
           "ERROR: NO EXISTEN EMPLEADOS",
           "ERROR: DATO INCORRECTO",
           "ERROR: EL USUARIO INGRESADO NO EXISTE",
           "ERROR: EL EMPLEADO INGRESADO NO EXISTE",
           "ERROR: EL CLIENTE INGRESADO NO EXISTE",
           "ERROR: ARGUMENTOS INCORRECTOS",
           "ERROR: NO HAS INTRODUCIDO NINGUN DATO",
           "ERROR: DEBES INTRODUCIR DOS APELLIDOS",
           "ERROR: DEBES INTRODUCIR UN MÁXIMO DE DOS NOMBRES",
           "ERROR: CONTRASEÑA INCORRECTA",
           "ERROR: CODIGO POSTAL INVALIDO",
           "ERROR: DEBE INDICAR UNA FECHA",
           "ERROR: HA OCURRIDO UN ERROR CON LA BASE DE DATOS",
           "ERROR: NO DISPONES DE LOS PERMISOS NECESARIOS PARA REALIZAR ESTA ACCION",
           "ERROR: EL NOMBRE, EMAIL, CIUDAD, COMUNIDAD AUTÓNOMA, REPRESENTANTE NO PUEDE TENER MÁS DE 45 CARÁCTERES",
           "ERROR: LA DIRECCIÓN NO PUEDE TENER MÁS DE 65 CARÁCTERES",
           "ERROR: LA PÁGINA WEB Y LA DESCRIPCION NO PUEDE TENER MÁS DE 255 CARÁCTERES",
           "ERROR: NO SE PUEDE BORRAR UN CLIENTE O EMPLEADO QUE TENGA ALGUNA ACCION EN EL HISTORIAL",
            "ERROR: LA COMISIÓN DEBE SER UN NÚMERO ENTERO ENTRE 0 Y 10 (AMBOS INCLUIDOS)",
            "ERROR: LA FECHA NO PUEDE SER ANTERIOR AL AÑO 2000",
            "ERROR: EL EMAIL NO PUEDE TENER MÁS DE 100 CARÁCTERES",
            "ERROR: EL TELÉFONO NO PUEDE TENER MÁS DE 9 CARÁCTERES",
            "ERROR: LA DIRECCION NO PUEDE TENER MÁS DE 60 CARÁCTERES",
            "ERROR: DEBES INTRODUCIR UN NÚMERO ENTERO"
    );

    private final int code;

    public ComandaException(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return mensajes.get(code);
    }
}
