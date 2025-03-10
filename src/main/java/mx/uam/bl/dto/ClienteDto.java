package mx.uam.bl.dto;

public class ClienteDto {
    private String name;
    private String lastname;
    private String Age;
    private String calle;
    private String colonia;
    private String ciudad;
    private String Pais;

    public ClienteDto(){
        
    }
    public ClienteDto(String Age, String Pais, String calle, String ciudad, String colonia, String lastname, String name) {
        this.Age = Age;
        this.Pais = Pais;
        this.calle = calle;
        this.ciudad = ciudad;
        this.colonia = colonia;
        this.lastname = lastname;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    
}
