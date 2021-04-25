package d18130496.ie.tudublin.Visual;



public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisualOfBands());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}