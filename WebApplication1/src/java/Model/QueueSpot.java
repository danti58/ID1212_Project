/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class QueueSpot {
    
    private String pin;
    private Integer activityId;
    private String location;
    private String comment;
    
    public QueueSpot(){
    }
    public QueueSpot(String pin, Integer activityId, String location, String comment){
        this.pin = pin;
        this.activityId = activityId;
        this.location = location;
        this.comment = comment;
    }
    
    public String getPin(){
        return this.pin;
    }
    public Integer getActivityId(){
        return this.activityId;
    }
    public String getLocation(){
        return this.location;
    }
    public String getComment(){
        return this.comment;
    }

}