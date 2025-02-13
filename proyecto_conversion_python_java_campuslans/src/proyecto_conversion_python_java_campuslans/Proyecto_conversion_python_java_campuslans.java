package proyecto_conversion_python_java_campuslans; 

import java.util.ArrayList;
import java.util.Scanner;

class Camper {
    public String nombre;
    public String apellido;
    public String idCam;
    public String telefono;

    public Camper(String nombre, String apellido, String idCam, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idCam = idCam;
        this.telefono = telefono;
    }

    public String getIdCam() {
        return idCam;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", ID: " + idCam + ", Telefono: " + telefono;
    }
}


public class Proyecto_conversion_python_java_campuslans {

    public static void main(String[] args) {

        ArrayList<Camper> nombresCamper = new ArrayList<>();
        int opcion = 0;
        Scanner scanner = new Scanner(System.in);

        while (opcion != 4) {
            System.out.println("==================== \n   Menu Principal \n====================");//MENU PRINCIPAL
            System.out.println("1.Cordinación ");
            System.out.println("2.Trainer ");
            System.out.println("3.Campers ");
            System.out.println("4.Cerrar sesión");

            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1 -> {
                    while (opcion != 5) {
                        System.out.println("====================== \n Bienvenido cordinador \n======================");// MENU COORDINACIÓN
                        System.out.println("1.Crear Camper");
                        System.out.println("2.Ver Camper");
                        System.out.println("3.Actualizar Campers");
                        System.out.println("4.Eliminar Camper");
                        System.out.println("5.Salir");
                        opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) { //---------------------------------------CREACION DE CAMPERS
                            case 1 -> {
                                System.out.println("1.crear camper");

                                System.out.println("Ingresa el nombre del camper");
                                String nombre = scanner.nextLine();

                                System.out.println("Ingresa el apellido del camper");
                                String apellido = scanner.nextLine();

                                System.out.println("Ingresa el Identificador unico del camper");
                                String idCam = scanner.nextLine();

                                System.out.println("Ingresa el telefono del camper");
                                String telefono = scanner.nextLine();

                                Camper nuevoCamper = new Camper(nombre, apellido, idCam, telefono); 
                                nombresCamper.add(nuevoCamper);
                                System.out.println("Camper creado exitosamente."); 
                            }

                            case 2 -> {//----------------------------------------------------------------VER CAMPERS
                                System.out.println("3.Ver Campers");
                                System.out.println("Ingrese el ID del alumno que desea ver: ");
                                String idcamper = scanner.nextLine();
                                for (Camper camper : nombresCamper) { 
                                    if (camper.getIdCam().equals(idcamper)) {
                                        System.out.println(camper); 
                                        break;
                                    }
                                }
                            }
                            
                            case 3 -> {
                                System.out.println("2.Actualizar camper "); //---------------------------------ACTUALIZAR CAMPERS
                                System.out.println("Ingrese el ID del alumno que desea actualizar:");
                                String idToUpdate = scanner.nextLine();

                                boolean camperFound = false;
                                for (Camper camper : nombresCamper) {
                                    if (camper.getIdCam().equals(idToUpdate)) {
                                        camperFound = true;

                                        System.out.println("Ingrese el nuevo nombre (o presione Enter para no cambiar):");
                                        String newName = scanner.nextLine();
                                        if (!newName.isEmpty()) {
                                            camper.nombre = newName;
                                        }

                                        System.out.println("Ingrese el nuevo apellido (o presione Enter para no cambiar):");
                                        String newLastName = scanner.nextLine();
                                        if (!newLastName.isEmpty()) {
                                            camper.apellido = newLastName;
                                        }

                                        System.out.println("Ingrese el nuevo teléfono (o presione Enter para no cambiar):");
                                        String newPhone = scanner.nextLine();
                                        if (!newPhone.isEmpty()) {
                                            camper.telefono = newPhone;
                                        }

                                        System.out.println("Camper actualizado exitosamente.");
                                        break; 
                                    }
                                }

                                if (!camperFound) {
                                    System.out.println("No se encontró ningún alumno con ese ID.");
                                }
                            }
                            case 4 -> { //--------------------------------------------------------------- Eliminar camper
                                System.out.println("4.Eliminar camper");
                                System.out.println("Inserte el ID del alumno que desea eliminar.");
                                String idEliminar = scanner.nextLine(); 

                                boolean camperEnc = false;

                                java.util.Iterator<Camper> iterator = nombresCamper.iterator();
                                while (iterator.hasNext()) {
                                    Camper camper = iterator.next();
                                    if (camper.getIdCam().equals(idEliminar)) {
                                        iterator.remove(); 
                                        System.out.println("Alumno eliminado");
                                        camperEnc = true;
                                        break; 
                                    }
                                }

                                if (!camperEnc) {
                                    System.out.println("No se encontró ningún alumno con ese ID.");
                                }
                            }
                        }
                    }
                    opcion = 0;
                }
                case 2 -> {
                    System.out.println("2.Trainer ");
                }
                case 3 -> {
                    System.out.println("3.Campers ");
                }
            }
        }
        scanner.close();
    }
}
 