package com.kelompok5.secondhand.result;

public class ErrorResult extends Result{
    public ErrorResult(){
        super(false);
    }

    public ErrorResult(String message){
        super(false, message);
    }
}
