package com.nsaxena.reststub;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import io.dropwizard.setup.Bootstrap;

/**
 * Hello world!
 *
 */
public class App extends Application<SimpleRestConfiguration>
{
    public static void main( String[] args ) throws Exception
    {
        new App().run(args);
    }
    @Override
    public void initialize(Bootstrap<SimpleRestConfiguration> bootstrap) 
    {
        // nothing to do yet
    }
	@Override
	public void run(SimpleRestConfiguration arg0, Environment arg1) throws Exception 
	{
		// TODO Auto-generated method stub
		
	}
}
