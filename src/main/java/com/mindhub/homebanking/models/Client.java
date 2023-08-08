package com.mindhub.homebanking.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {

//El tipo long representa un numero de entero, pero con mas espacio de almacenamiento
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
   @GenericGenerator(name = "native", strategy = "native")

   private Long id;
   private String firstName;
   private String lastName;
   private String email;

//Una propiedad nueva, mis cuentas
   @OneToMany(mappedBy="client", fetch=FetchType.EAGER)
   private Set<Account> accounts = new HashSet<>();


//Springboot me pide un constructor vacio
// Constructor vacio:
    public Client(){

    }

    //Constructor

    public Client(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    //Getters

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

//Agregar cuentas
    public void addAccount(Account account){
        //Decirle a la cuenta que el dueño soy yo
        account.setClient(this);
        //agregar la cuenta "account" que me pasaron a mi coleccion de cuentas
        accounts.add(account);
    }

    //Setter


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
