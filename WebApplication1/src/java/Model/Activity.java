/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class Activity {
    private Integer id;
    private String name;
    private boolean status;
    private String message;
    
    public Activity(){
    }
    public Activity(Integer id, String name, boolean status, String message){
        this.id = id;
        this.name = name;
        this.status = status;
        this.message = message;
    }

    public Integer getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public boolean getstatus(){
        return this.status;
    }
    public String getMessage(){
        return this.message;
    }
    public String setMessage(){
        return this.message;
    }
}
