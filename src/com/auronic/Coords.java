package com.auronic;

public class Coords {	
	private int BigX, BigY, SmallX, SmallY;
	
	public Coords(int i, int j, int k, int l) {
		this.BigX = i;
		this.BigY = j;
		this.SmallX = k;
		this.SmallY = l;
	}
	
/*	public class Woolie extends Thread {

	    *//**
	     * The number of seconds require to cross
	     *//*
	    private int crossingTime;

	    *//**
	     * The name of the destination of this woolie
	     *//*
	    private String destination;

	    *//**
	     * The bridge the woolie will cross
	     *//*
	    private Bridge theBridge;

	    *//**
	     * The troll guarding the bridge
	     *//*
	    private Troll bridgeGuard;
	    
	    *//**
	     * Construct a new Woolie object that can be started in a separate
	     * thread.  The constructor will simply initializes all of the 
	     * instance fields.
	     *
	     * @param       n    the name of this Woolie
	     * @param       c    the number of seconds it takes the Woolie to cross 
	     *                   the bridge
	     * @param       d    the city the Woolie is heading to
	     * @param       b    the bridge the Woolie is crossing
	     *
	     * Preconditions:<ul>
	     * <li>d = &quote;Sicstine&quote; or &quote;Merctran&quote;
	     * <li>c >= 0
	     * <li>n,b != null
	     * </ul>
	     *//*
	    public Woolie( String n, int c, String d, Bridge b ) {
	        super( n );
	        crossingTime = c;
	        destination = d;
	        theBridge = b;
	        bridgeGuard = theBridge.getTroll();
	    }
	    
	    *//**
	     * This method handles the Woolie's crossing of the bridge.  There
	     * are several messages that must be displayed to describe the Woolie's
	     * progress crossing the bridge.  <I>Note: In all the following
	     * messages</I>
	     * &quot;<code>name</code>&quot; <I>is the name of the Woolie.</I>
	     *
	     * <ul>
	     * <li>When the Woolie thread starts the message<br>
	     * <blockquote><code>name has arrived at the bridge.</code></blockquote>
	     * is displayed.
	     * <li>When the Woolie starts crossing the bridge, at time 0, the message
	     * <br>
	     * <blockquote><code>name is starting to cross.</code></blockquote>
	     * is displayed.
	     * <li>For every one second interval, beyond time 0, that the Woolie is on 
	     * the bridge a message<br>
	     * <blockquote><code>name x seconds.</code></blockquote>
	     * should be printed where &quot;<code>x</code>&quot;
	     * is the number of seconds that the Woolie has been on the bridge.
	     * <li>When the Woolie reaches its destination display the
	     * message<br>
	     * <blockquote><code>name leaves at city.</code></blockquote>
	     * where &quot;<code>city</code>&quot; is the Woolie's destination.
	     * </ul>
	     *//*

	    public void run() {

	        // The Woolie has started to cross the bridge

	        // System.out.println( getName() + " has arrived at the bridge.");

	        // Get permission to cross from the troll

	        bridgeGuard.enterBridgePlease();

	        // Simulate the time on the bridge

	        for ( int time = 0; time < crossingTime; time++ ) {
	            // Take care of output

	            if( time == 0 )
	                System.out.println( getName() + " is starting to cross." );
	            else
	                System.out.println( "\t" + getName() + ' ' + time + " seconds." );

	            // Let time pass

	            try {
	                sleep(1000);
	            }
	            catch( InterruptedException e ) {}
	        }

	        // Tell the bridge we have crossed

	        bridgeGuard.leave();

	        // Finished crossing

	        System.out.println( getName() + " leaves at " + destination + "." );
	    }
	}*/

	public int getBigX() {
		return BigX;
	}

	public int getBigY() {
		return BigY;
	}

	public int getSmallX() {
		return SmallX;
	}

	public int getSmallY() {
		return SmallY;
	}
	
	
}
