class Paciente {
    String DNI;
    String nombre;
    String apellido;
    String direccion;
    double peso;
    double temperatura;
    Medico medico; // Relación con el médico que lo atendió

   

    public Paciente(String dNI, String nombre, String apellido, String direccion, double peso, double temperatura) {
        DNI = dNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.peso = peso;
        this.temperatura = temperatura;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}