package com.example.anubusroutes;

import android.widget.Toast;

public class EmptyFieldException extends Exception{
    public EmptyFieldException(String message){
       super(message);
    }
}
