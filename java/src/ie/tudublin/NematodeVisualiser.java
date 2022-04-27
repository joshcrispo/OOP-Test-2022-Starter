package ie.tudublin;

import java.util.ArrayList;

import com.jogamp.opengl.FBObject.RenderAttachment;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	void printNematodes()
	{
		for(Nematode nT:nematodes)
		{
			System.out.println(nT);
		}
	}

	int choice = 0;

	public void keyPressed()
    {
        if (keyCode == LEFT)
        {
            choice -= 1;
            if ( choice== -1)
            {
                choice =12;
            }
        }

        if (keyCode == RIGHT)
        {
            choice +=1;
            if (choice==13)
            {
                choice=0;
            }
        }
    }

	public void drawNematodes()
	{
		for(Nematode nT:nematodes)
		{
			nematodes.get(choice).render(this);
		}
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();
		loadNematodes();
		printNematodes();				
	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");
		for(TableRow r:table.rows())
		{
			Nematode nT = new Nematode(r);
			nematodes.add(nT);
		}
	}


	public void draw()
	{	
		background(0);
		drawNematodes();
	}
}
