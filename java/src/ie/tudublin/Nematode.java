package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Nematode {
    
    private String name;
    private int length;
    private boolean limbs;
    private String gender;
    private boolean eyes;

    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }

    public Nematode(String name, int length, boolean limbs, String gender, boolean eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }

    public Nematode(TableRow tr)
    {
        this(
            tr.getString("name"),
            tr.getInt("length"), 
            tr.getInt("limbs") == 1,
            tr.getString("gender"),
            tr.getInt("eyes") == 1
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isLimbs() {
        return limbs;
    }

    public void setLimbs(boolean limbs) {
        this.limbs = limbs;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isEyes() {
        return eyes;
    }

    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }
   

    public void render(NematodeVisualiser pa)
    {
        float circleSize = 50;

        float border = (pa.height - (length * circleSize)) / 2;
        float y;
        float x = pa.width / 2;

        pa.ellipseMode(PApplet.CENTER);
        pa.noFill();
        pa.stroke(255);


        for (int i = 0; i < length; i++)
        {
            y = PApplet.map(i, 0, length, border, pa.height - border);
            pa.circle(x, y, circleSize);
            if (limbs == true)
            {
                pa.line(x - circleSize / 2, y, x - circleSize / 2 - 15, y);
                pa.line(x + circleSize / 2, y, x + circleSize / 2 + 15, y);
            }
            
        }

        int i = 0;
        y = PApplet.map(i, 0, length, border, pa.height - border);
        if (eyes == true)
        {
            pa.line(x-20, y-15, x-35, y-30);
            pa.line(x+20, y-15, x+35, y-30);
            pa.circle(x-37, y-32, 5);
            pa.circle(x+37, y-32, 5);
        }

        y = PApplet.map(length, 0, length, border, pa.height - border);
        y -= circleSize;
    
        //gender thing
        if (gender.contains("m")) {
            pa.line(x, y + 20, x, y+ 40);
            pa.circle(x, y + 44, 5);
        }

        if (gender.contains("f")) {
            pa.circle(x, y, 20);
        }

        if (gender.contains("h")) {
            pa.line(x, y + 20, x, y + 40);
            pa.circle(x, y + 44, 5);
            pa.circle(x, y, 20);
        }

        x = pa.width/2;
        y = pa.height/2;

        pa.triangle(x-300, y,x-200,y-50,x-200,y+50);
        pa.triangle(x+300, y,x+200,y-50,x+200,y+50);
        
    }
}

