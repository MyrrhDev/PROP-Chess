package Domini;

import java.util.HashMap;

public class Peon extends Pieza {

    public boolean firstMove;

    /* Pre: Cierto
     * Post: Se crea un objeto peon y se inicializa si es su primer movimiento
     */
    public Peon() {
        firstMove = false;

    }

    /* Pre: Cierto
     * Post: Se crea un objeto peon con los parámetros esNegra, id, posX, posY
     */
    public Peon(boolean esNegra, Integer id) {
        this.esNegra = esNegra;
        this.id = id;
    }



    /*
     * Pre: Los atributos de la clase Pieza posX y posY están actualizados para la la verificacion del movimiento
     * Post: La funcion devuelve:
     *       * True: Si el movimiento que se quiere realizar es correcto
     *       * False: Si no se puede realizar el movimiento
     */

    boolean esMovimientoOk(int movX, int movY, int estadoTablero[][], HashMap<Integer, Pieza> piezasTablero) {
        int posX = -1, posY = -1;
        int x = 0, y = 0;
        boolean found = false;
        while(x < 8 && !found) {
            y = 0;
            while (y < 8 && !found) {
                if(estadoTablero[x][y] == this.id) {
                    found = true;
                    posX = x;
                    posY = y;
                }
                ++y;
            }
            ++x;
        }
        //primero verificamos que el movimiento deseado no salga del tablero
        if(movX >= 0 && movX < 8 && movY >= 0 && movY < 8) {
            int auxX = movX - posX;
            int auxY = movY - posY;

            if (movX < posX && movY != posY) { //movimiento alguno valido
                //Anyone to kill?  //Diagonal solo si se puede matar
                if (auxX == -1 && auxY == -1) { //movimiento hacia esquina superior izquierda
                    if (estadoTablero[movX][movY] != 0) {
                        //me encuentro una pieza en mi camino
                        Pieza p = piezasTablero.get(estadoTablero[movX][movY]);
                        if (p.isEsNegra() == esNegra) return false;
                        else return true;
                    } else return false;
                } else if (auxX == -1 && auxY == 1) { //movimiento hacia esquina superior derecha
                    if (estadoTablero[movX][movY] != 0) {
                        //me encuentro una pieza en mi camino
                        Pieza p = piezasTablero.get(estadoTablero[movX][movY]);
                        if (p.isEsNegra() == esNegra) return false;
                        else return true;
                    } else return false;
                } else if (movY == posY && movX < posX) { //mov hacia adelante
                    if (firstMove && auxY == -2) {
                        if (estadoTablero[movX][movY] == 0) { //no hay pieza alguna
                            return true;
                        }
                    } else if (auxY == -2 && !firstMove) return false;

                    else if (auxX == -1) {
                        if (estadoTablero[movX][movY] == 0) { //no hay pieza alguna
                            return true;
                        }
                    } else return false;
                } else return false; //la pieza no se ha movido realmente
            } else return false;
        }
        return false;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

}
