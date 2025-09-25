package com.example.task06;

public class Task06Main {
    public static void main(String[] args) {
        //здесь вы можете вручную протестировать ваше решение, вызывая реализуемый метод и смотря результат
        // например вот так:
    }

    public void printMethodName() {
        // Использую stackTrace чтобы отследить название вызвавшего метода
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            System.out.println(stackTrace[1].getMethodName());
        }
    }

}