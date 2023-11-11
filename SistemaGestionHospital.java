import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class SistemaGestionHospital {
    private static ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private static ArrayList<Medico> listaMedicos = new ArrayList<>();
    

    public static void main(String[] args) {
        //PACIENTES 
        listaPacientes.add(new Paciente("111111", "Juan", "Pérez", "Calle A, Ciudad", 75.5, 37.0));
        listaPacientes.add(new Paciente("222222", "María", "López", "Calle B, Ciudad", 65.2, 36.8));
        listaPacientes.add(new Paciente("333333", "Carlos", "Martínez", "Calle C, Ciudad", 80.0, 37.2));
        listaPacientes.add(new Paciente("444444", "Laura", "González", "Calle D, Ciudad", 72.8, 37.5));
        listaPacientes.add(new Paciente("555555", "Pedro", "Ramírez", "Calle E, Ciudad", 68.3, 36.9));
        listaPacientes.add(new Paciente("666666", "Ana", "Torres", "Calle F, Ciudad", 68.3, 36.7));
        listaPacientes.add(new Paciente("777777", "Javier", "Sánchez", "Calle G, Ciudad", 85.5, 37.1));
        listaPacientes.add(new Paciente("888888", "Sofía", "Rodríguez", "Calle H, Ciudad", 78.4, 36.8));
        listaPacientes.add(new Paciente("999999", "Diego", "Gómez", "Calle I, Ciudad", 69.7, 37.3));
        listaPacientes.add(new Paciente("101010", "Valeria", "Herrera", "Calle J, Ciudad", 76.9, 36.6));

        //MEDICOS
        listaMedicos.add(new Medico("CM001", "Dr. García", "Cardiología"));
        listaMedicos.add(new Medico("OR002", "Dra. Martínez", "Ortopedia"));
        listaMedicos.add(new Medico("NEU003", "Dr. Ramírez", "Neurología"));
        listaMedicos.add(new Medico("GYN004", "Dra. Torres", "Ginecología"));
        listaMedicos.add(new Medico("DER005", "Dr. López", "Dermatología"));
        listaMedicos.add(new Medico("PSI006", "Dra. González", "Psiquiatría"));
        listaMedicos.add(new Medico("END007", "Dr. Sánchez", "Endocrinología"));
        listaMedicos.add(new Medico("URO008", "Dra. Rodríguez", "Urología"));
        listaMedicos.add(new Medico("OFT009", "Dr. Gómez", "Oftalmología"));
        listaMedicos.add(new Medico("PED010", "Dra. Herrera", "Pediatría"));
        //ASIGNAR
        asignarMedicoAPaciente(listaPacientes.get(0), listaMedicos.get(0)); // Juan Pérez - Dr. García
        asignarMedicoAPaciente(listaPacientes.get(1), listaMedicos.get(1)); // María López - Dra. Martínez
        asignarMedicoAPaciente(listaPacientes.get(2), listaMedicos.get(2)); // Carlos Martínez - Dr. Ramírez
        asignarMedicoAPaciente(listaPacientes.get(3), listaMedicos.get(3)); // Laura González - Dra. Torres
        asignarMedicoAPaciente(listaPacientes.get(4), listaMedicos.get(4)); // Pedro Ramírez - Dr. López
        asignarMedicoAPaciente(listaPacientes.get(5), listaMedicos.get(5)); // Ana Torres - Dra. González
        asignarMedicoAPaciente(listaPacientes.get(6), listaMedicos.get(6)); // Javier Sánchez - Dr. Sánchez
        asignarMedicoAPaciente(listaPacientes.get(7), listaMedicos.get(7)); // Sofía Rodríguez - Dra. Rodríguez
        asignarMedicoAPaciente(listaPacientes.get(8), listaMedicos.get(8)); // Diego Gómez - Dr. Gómez
        asignarMedicoAPaciente(listaPacientes.get(9), listaMedicos.get(9)); // Valeria Herrera - Dra. Herrera
       
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nOperaciones:");
            System.out.println("1. Registrar datos de pacientes");
            System.out.println("2. Eliminar datos de un paciente");
            System.out.println("3. Modificar datos de un paciente");
            System.out.println("4. Mostrar el peso que más se repite");
            System.out.println("5. Mostrar cantidad de pacientes con el peso que más se repite");
            System.out.println("6. Mostrar el peso mayor y menor");
            System.out.println("7. Dividir el rango de pesos y mostrar cantidad en cada rango");
            System.out.println("8. Mostrar lista de pacientes ordenados por apellidos");
            System.out.println("9. Indicar qué doctor atendió a un paciente");
            System.out.println("10. Buscar doctores por especialidad");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                registrarPacienteConMedico();
                    break;
                case 2:
                    eliminarPaciente();
                    break;
                case 3:
                    modificarPaciente();
                    break;
                case 4:
                    mostrarPesoMasRepite();
                    break;
                case 5:
                    mostrarCantidadPacientesPesoRepite();
                    break;
                case 6:
                    mostrarPesoMayorMenor();
                    break;
                case 7:
                    mostrarCantidadEnRangosDePesos();
                    break;
                case 8:
                    mostrarListaPacientesOrdenados();
                    break;
                case 9:
                    indicarDoctorAtendio();
                    break;
                case 10:
                    buscarDoctoresPorEspecialidad();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }

        } while (opcion != 0);
    }

    
    private static void registrarPacienteConMedico() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Ingrese el DNI del paciente: ");
        String dni = scanner.next();
    
        System.out.print("Ingrese el nombre del paciente: ");
        String nombre = scanner.next();
        
        System.out.print("Ingrese el apellido del paciente: ");
        String apellido = scanner.next();
    
        System.out.print("Ingrese la dirección del paciente: ");
        String direccion = scanner.next();
    
        System.out.print("Ingrese el peso del paciente: ");
        double peso = scanner.nextDouble();
    
        System.out.print("Ingrese la temperatura del paciente: ");
        double temperatura = scanner.nextDouble();
    
        // Mostrar lista de médicos para que el usuario elija uno
        System.out.println("Lista de Médicos:");
        for (int i = 0; i < listaMedicos.size(); i++) {
            System.out.println((i + 1) + ". " + listaMedicos.get(i).getNombre());
        }
    
        System.out.print("Seleccione el número del médico que atenderá al paciente: ");
        int numeroMedico = scanner.nextInt();
    
        if (numeroMedico > 0 && numeroMedico <= listaMedicos.size()) {
            Medico medicoSeleccionado = listaMedicos.get(numeroMedico - 1);
    
            Paciente paciente = new Paciente(dni, nombre, apellido, direccion, peso, temperatura);
            paciente.setMedico(medicoSeleccionado);

    
            listaPacientes.add(paciente);
    
            System.out.println("Paciente registrado y asignado al médico " + medicoSeleccionado.getNombre() + " exitosamente.");
        } else {
            System.out.println("Número de médico no válido. No se asignó un médico al paciente.");
        }
    }

    private static void eliminarPaciente() {
        Scanner scanner = new Scanner(System.in);

        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes para eliminar.");
            return;
        }

        System.out.println("Lista de Pacientes:");
        for (int i = 0; i < listaPacientes.size(); i++) {
            System.out.println((i + 1) + ". " + listaPacientes.get(i).nombre);
        }

        System.out.print("Seleccione el número del paciente a eliminar: ");
        int posicion = scanner.nextInt() - 1;

        if (posicion >= 0 && posicion < listaPacientes.size()) {
            listaPacientes.remove(posicion);
            System.out.println("Paciente eliminado exitosamente.");
        } else {
            System.out.println("Número de paciente no válido.");
        }
    }

    private static void modificarPaciente() {
        Scanner scanner = new Scanner(System.in);

        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes para modificar.");
            return;
        }

        System.out.println("Lista de Pacientes:");
        for (int i = 0; i < listaPacientes.size(); i++) {
            System.out.println((i + 1) + ". " + listaPacientes.get(i).nombre);
        }

        System.out.print("Seleccione el número del paciente a modificar: ");
        int posicion = scanner.nextInt() - 1;

        if (posicion >= 0 && posicion < listaPacientes.size()) {
            Paciente paciente = listaPacientes.get(posicion);

            System.out.println("Modificar paciente: " + paciente.nombre);
            System.out.print("Ingrese el nuevo DNI del paciente: ");
            String dni = scanner.next();
            paciente.DNI = dni;

            System.out.print("Ingrese el nuevo nombre del paciente: ");
            String nombre = scanner.next();
            paciente.nombre = nombre;

            System.out.print("Ingrese la nueva dirección del paciente: ");
            String direccion = scanner.next();
            paciente.direccion = direccion;

            System.out.print("Ingrese el nuevo peso del paciente: ");
            double peso = scanner.nextDouble();
            paciente.peso = peso;

            System.out.print("Ingrese la nueva temperatura del paciente: ");
            double temperatura = scanner.nextDouble();
            paciente.temperatura = temperatura;

            System.out.println("Datos modificados exitosamente.");
        } else {
            System.out.println("Número de paciente no válido.");
        }
    }

    private static void mostrarPesoMasRepite() {
        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes para mostrar.");
            return;
        }

        HashMap<Double, Integer> contadorPesos = new HashMap<>();
        for (Paciente paciente : listaPacientes) {
            if (contadorPesos.containsKey(paciente.peso)) {
                contadorPesos.put(paciente.peso, contadorPesos.get(paciente.peso) + 1);
            } else {
                contadorPesos.put(paciente.peso, 1);
            }
        }

        if (!contadorPesos.isEmpty()) {
            double pesoMasRepetido = Collections.max(contadorPesos.entrySet(), Map.Entry.comparingByValue()).getKey();
            System.out.println("El peso que más se repite es: " + pesoMasRepetido);
        } else {
            System.out.println("No hay datos de peso para mostrar.");
        }
    }

    private static void mostrarCantidadPacientesPesoRepite() {
        mostrarPesoMasRepite();

        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes para mostrar.");
            return;
        }

        double pesoMasRepetido = 0;
        for (Paciente paciente : listaPacientes) {
            if (paciente.peso == pesoMasRepetido) {
                System.out.println("La cantidad de pacientes que tienen el peso que más se repite es: " + 1);
                return;
            }
        }
    }

    private static void mostrarPesoMayorMenor() {
        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes para mostrar.");
            return;
        }

        double pesoMayor = Double.MIN_VALUE;
        double pesoMenor = Double.MAX_VALUE;

        for (Paciente paciente : listaPacientes) {
            if (paciente.peso > pesoMayor) {
                pesoMayor = paciente.peso;
            }
            if (paciente.peso < pesoMenor) {
                pesoMenor = paciente.peso;
            }
        }

        System.out.println("El peso mayor es: " + pesoMayor);
        System.out.println("El peso menor es: " + pesoMenor);
    }

    private static void mostrarCantidadEnRangosDePesos() {
        mostrarPesoMayorMenor();

        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes para mostrar.");
            return;
        }

        double pesoMayor = 0;
        double pesoMenor = 0;

        for (Paciente paciente : listaPacientes) {
            if (paciente.peso == pesoMayor) {
                pesoMayor = paciente.peso;
            }
            if (paciente.peso == pesoMenor) {
                pesoMenor = paciente.peso;
            }
        }

        double rangoMinimo = pesoMenor + 5;
        double rangoMaximo = pesoMayor - 5;

        int cantidadRango1 = 0, cantidadRango2 = 0, cantidadRango3 = 0, cantidadRango4 = 0;

        for (Paciente paciente : listaPacientes) {
            if (paciente.peso >= pesoMenor && paciente.peso <= rangoMinimo) {
                cantidadRango1++;
            } else if (paciente.peso > rangoMinimo && paciente.peso <= rangoMaximo) {
                cantidadRango2++;
            } else if (paciente.peso > rangoMaximo && paciente.peso <= pesoMayor) {
                cantidadRango3++;
            } else if (paciente.peso > pesoMayor) {
                cantidadRango4++;
            }
        }

        System.out.println("Cantidad de personas en el rango " + pesoMenor + " - " + rangoMinimo + ": " + cantidadRango1);
        System.out.println("Cantidad de personas en el rango " + rangoMinimo + " - " + rangoMaximo + ": " + cantidadRango2);
        System.out.println("Cantidad de personas en el rango " + rangoMaximo + " - " + pesoMayor + ": " + cantidadRango3);
        System.out.println("Cantidad de personas en el rango mayor a " + pesoMayor + ": " + cantidadRango4);
    }

    private static void mostrarListaPacientesOrdenados() {
        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes para mostrar.");
            return;
        }
    
        // Ordenar la lista de pacientes por apellidos (se asume que el apellido es la última palabra en el nombre)
        Collections.sort(listaPacientes, (p1, p2) -> {
            String[] apellido1 = p1.apellido.split(" ");
            String[] apellido2 = p2.apellido.split(" ");
            return apellido1[apellido1.length - 1].compareTo(apellido2[apellido2.length - 1]);
        });
    
        System.out.println("Lista de Pacientes Ordenados por Apellidos:");
    
        for (Paciente paciente : listaPacientes) {
            System.out.println("Nombre: " + paciente.nombre + " " + paciente.apellido +
                    ", Dirección: " + paciente.direccion +
                    ", Médico: " + (paciente.medico != null ? paciente.medico.nombre : "No asignado"));
        }
    }
    

    private static void indicarDoctorAtendio() {
        Scanner scanner = new Scanner(System.in);

        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes para mostrar.");
            return;
        }

        System.out.println("Lista de Pacientes:");
        for (int i = 0; i < listaPacientes.size(); i++) {
            System.out.println((i + 1) + ". " + listaPacientes.get(i).nombre);
        }

        System.out.print("Seleccione el número del paciente para conocer al médico que lo atendió: ");
        int posicion = scanner.nextInt() - 1;

        if (posicion >= 0 && posicion < listaPacientes.size()) {
            Paciente paciente = listaPacientes.get(posicion);
            System.out.println("El paciente " + paciente.nombre + " fue atendido por el médico " + paciente.medico.nombre);
        } else {
            System.out.println("Número de paciente no válido.");
        }
    }
    private static void asignarMedicoAPaciente(Paciente paciente, Medico medico) {
        paciente.setMedico(medico);
    }

    private static void buscarDoctoresPorEspecialidad() {
        Scanner scanner = new Scanner(System.in);
    
        if (listaMedicos.isEmpty()) {
            System.out.println("No hay médicos para mostrar.");
            return;
        }
    
        System.out.println("Especialidades disponibles:");
        System.out.println("1. Cardiología");
        System.out.println("2. Ortopedia");
        System.out.println("3. Neurología");
        System.out.println("4. Ginecología");
        System.out.println("5. Dermatología");
        System.out.println("6. Psiquiatría");
        System.out.println("7. Endocrinología");
        System.out.println("8. Urología");
        System.out.println("9. Oftalmología");
        System.out.println("10. Pediatría");
      ;
    
        System.out.print("Seleccione la especialidad a buscar (1-10): ");
        int opcionSeleccionada = scanner.nextInt();
    
        String especialidadBuscada = null;
    
        switch (opcionSeleccionada) {
            case 1:
                especialidadBuscada = "Cardiología";
                break;
            case 2:
                especialidadBuscada = "Ortopedia";
                break;
            case 3:
                especialidadBuscada = "Neurología";
                break;
              case 4:
                especialidadBuscada = "Ginecología";
                break;
            case 5:
                especialidadBuscada = "Dermatología";
                break;
            case 6:
                especialidadBuscada = "Psiquiatría";
                break;

             case 7:
                especialidadBuscada = "Endocrinología";
                break;


             case 8:
                especialidadBuscada = "Urología";
                break;
            case 9:
                especialidadBuscada = "Oftalmología";
                break;
            case 10:
                especialidadBuscada = "Pediatría";
                break;
            
            default:
                System.out.println("Opción no válida. Seleccione un número de especialidad válido.");
                return;
        }
    
        boolean encontrado = false;
    
        for (Medico medico : listaMedicos) {
            if (medico.getEspecialidad().equalsIgnoreCase(especialidadBuscada)) {
                System.out.println("Médico encontrado: ");
                System.out.println("Número de Colegiatura: " + medico.getNumeroColegiatura());
                System.out.println("Nombre: " + medico.getNombre());
                System.out.println("Especialidad: " + medico.getEspecialidad());
                System.out.println("--------------------------");
                encontrado = true;
            }
        }
    
        if (!encontrado) {
            System.out.println("No se encontraron médicos con la especialidad especificada.");
        }
    }
    
    
}