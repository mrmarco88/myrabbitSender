package com.filelife.myrabbitSender.domain;

class OuterClass{
    public static class StaticNestedClass{
    }

    public  class InnerClass{
    }

    public InnerClass getAnInnerClass(){
        return new InnerClass();
    }

    //This method doesn't work
    public static InnerClass getAnInnerClassStatically(){
    	OuterClass oc = new OuterClass();
        return oc.getAnInnerClass();
    }
}
