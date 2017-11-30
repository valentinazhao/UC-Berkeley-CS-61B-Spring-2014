/* PixImage.java */

public class PixImage {
 
/**
   *  Define any variables associated with a PixImage object here.  These
   *  variables MUST be private.
   */
  
  private static int size; 
  private int width, height; 
  private short[][] Red;
  private short[][] Green;
  private short[][] Blue;
  
  public PixImage(int width, int height) {
    // Your solution here.
	  this.width = width;
	  this.height = height;
	  Red = new short[width][height];
	  Green = new short[width][height];
	  Blue = new short[width][height];
	  for(int i = 0; i < width; i++) {
		  for(int j = 0; j < height; j++) {
			  Red[i][j] = 0;
			  Green[i][j] = 0;
			  Blue[i][j] = 0;
		  }
	  }
  }

  
  public int getWidth() {
    // Replace the following line with your solution.
    return this.width;
  }

  public int getHeight() {
    // Replace the following line with your solution.
    return this.height;
  }

  public short getRed(int x, int y) {
	    // Replace the following line with your solution.
	    return Red[x][y];
	  }

	  public short getGreen(int x, int y) {
	    // Replace the following line with your solution.
	    return Green[x][y];
	  }

	  public short getBlue(int x, int y) {
	    // Replace the following line with your solution.
	    return Blue[x][y];
	  }

  
  public void setPixel(int x, int y, short red, short green, short blue) {
    // Your solution here.
	// In a image to every pixel of it, not targeted to image itself
	  if(0 <= red && red <= 255 && 0 <= green && green <= 255 && 0 <= blue && blue <= 255){
	      Red[x][y] = red;
	      Green[x][y] = green;
	      Blue[x][y] = blue;
	    }
  }

  
  public String toString() {
    // Replace the following line with your solution.
	  String p = new String();
	    for(int j = 0; j < height; j++)
	      for(int i = 0; i < width; i++){
	        p = p + "| "+ Red[i][j] + " " + Green[i][j] + " " + Blue[i][j] + " ";
	        if(i == width - 1){
	          p = p + "|\n";
	        }
	      }
	    return p;
  }

  
  public PixImage boxBlur(int numIterations) {
    // Replace the following line with your solution.
	  if(numIterations <= 0) {
		  return this;  
	  }else {
		  PixImage cal_this = this;
		  //PixImage cal_that = new PixImage(width, height);
		  int cal_r;
		  int cal_g;
		  int cal_b;
		  for(int t = 1; t <= numIterations; t++) {
			  PixImage cal_that = new PixImage(width, height);
			  for(int i = 0; i < width; i++) {
				  for(int j = 0; j < height; j++) {
					  if(i == 0 && j == 0){
			              cal_r = (cal_this.Red[i][j] + cal_this.Red[i+1][j] + cal_this.Red[i][j+1] + cal_this.Red[i+1][j+1])/4;
			              cal_g = (cal_this.Green[i][j] + cal_this.Green[i+1][j] + cal_this.Green[i][j+1] + cal_this.Green[i+1][j+1])/4;
			              cal_b = (cal_this.Blue[i][j] + cal_this.Blue[i+1][j] + cal_this.Blue[i][j+1] + cal_this.Blue[i+1][j+1])/4;
			          }else if(i == width-1 && j == 0){
			            cal_r = (cal_this.Red[i][j] + cal_this.Red[i-1][j] + cal_this.Red[i][j+1] + cal_this.Red[i-1][j+1])/4; 
			            cal_g = (cal_this.Green[i][j] + cal_this.Blue[i-1][j] + cal_this.Blue[i][j+1] + cal_this.Blue[i-1][j+1])/4;
			            cal_b = (cal_this.Blue[i][j] + cal_this.Blue[i-1][j] + cal_this.Blue[i][j+1] + cal_this.Blue[i-1][j+1])/4;
			          }else if(i == 0 && j == height -1){
			            cal_r = (cal_this.Red[i][j] + cal_this.Red[i+1][j] + cal_this.Red[i][j-1] + cal_this.Red[i+1][j-1])/4;
			            cal_g = (cal_this.Green[i][j] + cal_this.Green[i+1][j] + cal_this.Green[i][j-1] + cal_this.Green[i+1][j-1])/4;
			            cal_b = (cal_this.Blue[i][j] + cal_this.Blue[i+1][j] + cal_this.Blue[i][j-1] + cal_this.Blue[i+1][j-1])/4;
			          }else if(i == width-1 && j == height - 1){
			            cal_r = (cal_this.Red[i][j] + cal_this.Red[i-1][j] + cal_this.Red[i][j-1] + cal_this.Red[i-1][j-1])/4;
			            cal_g = (cal_this.Green[i][j] + cal_this.Green[i-1][j] + cal_this.Green[i][j-1] + cal_this.Green[i-1][j-1])/4;
			            cal_b = (cal_this.Blue[i][j] + cal_this.Blue[i-1][j] + cal_this.Blue[i][j-1] + cal_this.Blue[i-1][j-1])/4;
			          }else if(j == 0){
			            cal_r = (cal_this.Red[i][j] + cal_this.Red[i-1][j] + cal_this.Red[i+1][j] + cal_this.Red[i][j+1] + cal_this.Red[i-1][j+1] + cal_this.Red[i+1][j+1])/6;
			            cal_g = (cal_this.Green[i][j] + cal_this.Green[i-1][j] + cal_this.Green[i+1][j] + cal_this.Green[i][j+1] + cal_this.Green[i-1][j+1] + cal_this.Green[i+1][j+1])/6;
			            cal_b = (cal_this.Blue[i][j] + cal_this.Blue[i-1][j] + cal_this.Blue[i+1][j] + cal_this.Blue[i][j+1] + cal_this.Blue[i-1][j+1] + cal_this.Blue[i+1][j+1])/6;
			          }else if(j == height-1){
			            cal_r = (cal_this.Red[i][j] + cal_this.Red[i-1][j] + cal_this.Red[i+1][j] + cal_this.Red[i][j-1] + cal_this.Red[i-1][j-1] + cal_this.Red[i+1][j-1])/6;
			            cal_g = (cal_this.Green[i][j] + cal_this.Green[i-1][j] + cal_this.Green[i+1][j] + cal_this.Green[i][j-1] + cal_this.Green[i-1][j-1] + cal_this.Green[i+1][j-1])/6;
			            cal_b = (cal_this.Blue[i][j] + cal_this.Blue[i-1][j] + cal_this.Blue[i+1][j] + cal_this.Blue[i][j-1] + cal_this.Blue[i-1][j-1] + cal_this.Blue[i+1][j-1])/6;
			          }else if(i == 0){
			            cal_r = (cal_this.Red[i][j] + cal_this.Red[i][j-1] + cal_this.Red[i][j+1] + cal_this.Red[i+1][j] + cal_this.Red[i+1][j-1] + cal_this.Red[i+1][j+1])/6;
			            cal_g = (cal_this.Green[i][j] + cal_this.Green[i][j-1] + cal_this.Green[i][j+1] + cal_this.Green[i+1][j] + cal_this.Green[i+1][j-1] + cal_this.Green[i+1][j+1])/6;
			            cal_b = (cal_this.Blue[i][j] + cal_this.Blue[i][j-1] + cal_this.Blue[i][j+1] + cal_this.Blue[i+1][j] + cal_this.Blue[i+1][j-1] + cal_this.Blue[i+1][j+1])/6;
			          }else if(i == width-1){
			            cal_r = (cal_this.Red[i][j] + cal_this.Red[i][j-1] + cal_this.Red[i][j+1] + cal_this.Red[i-1][j] + cal_this.Red[i-1][j-1] + cal_this.Red[i-1][j+1])/6;
			            cal_g = (cal_this.Green[i][j] + cal_this.Green[i][j-1] + cal_this.Green[i][j+1] + cal_this.Green[i-1][j] + cal_this.Green[i-1][j-1] + cal_this.Green[i-1][j+1])/6;
			            cal_b = (cal_this.Blue[i][j] + cal_this.Blue[i][j-1] + cal_this.Blue[i][j+1] + cal_this.Blue[i-1][j] + cal_this.Blue[i-1][j-1] + cal_this.Blue[i-1][j+1])/6;
			          }else{
			            cal_r = (cal_this.Red[i][j] + cal_this.Red[i-1][j] + cal_this.Red[i+1][j] + cal_this.Red[i][j-1] + cal_this.Red[i-1][j-1] + cal_this.Red[i+1][j-1] + cal_this.Red[i][j+1] + cal_this.Red[i-1][j+1] + cal_this.Red[i+1][j+1])/9;
			            cal_g = (cal_this.Green[i][j] + cal_this.Green[i-1][j] + cal_this.Green[i+1][j] + cal_this.Green[i][j-1] + cal_this.Green[i-1][j-1] + cal_this.Green[i+1][j-1] + cal_this.Green[i][j+1] + cal_this.Green[i-1][j+1] + cal_this.Green[i+1][j+1])/9;
			            cal_b = (cal_this.Blue[i][j] + cal_this.Blue[i-1][j] + cal_this.Blue[i+1][j] + cal_this.Blue[i][j-1] + cal_this.Blue[i-1][j-1] + cal_this.Blue[i+1][j-1] + cal_this.Blue[i][j+1] + cal_this.Blue[i-1][j+1] + cal_this.Blue[i+1][j+1])/9;
			          }
					  cal_that.setPixel(i, j, (short)cal_r, (short)cal_g, (short)cal_b);
				  }
			  }
			  cal_this = cal_that;
		  }
		  return cal_this;
	  }
  } 

  
  private static short mag2gray(long mag) {
    short intensity = (short) (30.0 * Math.log(1.0 + (double) mag) - 256.0);

    // Make sure the returned intensity is in the range 0...255, regardless of
    // the input value.
    if (intensity < 0) {
      intensity = 0;
    } else if (intensity > 255) {
      intensity = 255;
    }
    return intensity;
  }

 
  public PixImage sobelEdges() {
    // Replace the following line with your solution.
	  long gx_r, gy_r;
	  long gx_g, gy_g;
	  long gx_b, gy_b;
	  long energy;
	  short mag;
	  PixImage img = new PixImage(width, height);
      for(int i = 0; i < width; i++) {
    	  for(int j = 0; j < height; j++) {
    		  if(i == 0 && j == 0){
                  gx_r = (Red[i][j] + 0*Red[i][j] + (-1)*Red[i+1][j] + 2*Red[i][j] + 0*Red[i][j] + (-2)*Red[i+1][j] + Red[i][j+1] + 0*Red[i][j+1] + (-1)*Red[i+1][j+1]);
                  gx_g = (Green[i][j] + 0*Green[i][j] + (-1)*Green[i+1][j] + 2*Green[i][j] + 0*Green[i][j] + (-2)*Green[i+1][j] + Green[i][j+1] + 0*Green[i][j+1] + (-1)*Green[i+1][j+1]);
                  gx_b = (Blue[i][j] + 0*Blue[i][j] + (-1)*Blue[i+1][j] + 2*Blue[i][j] + 0*Blue[i][j] + (-2)*Blue[i+1][j] + Blue[i][j+1] + 0*Blue[i][j+1] + (-1)*Blue[i+1][j+1]);
                  gy_r = (Red[i][j] + 2*Red[i][j] + Red[i+1][j] + 0*Red[i][j] + 0*Red[i][j] + 0*Red[i+1][j] + (-1)*Red[i][j+1] + (-2)*Red[i][j+1] + (-1)*Red[i+1][j+1]);
                  gy_g = (Green[i][j] + 2*Green[i][j] + Green[i+1][j] + 0*Green[i][j] + 0*Green[i][j] + 0*Green[i+1][j] + (-1)*Green[i][j+1] + (-2)*Green[i][j+1] + (-1)*Green[i+1][j+1]);
                  gy_b = (Blue[i][j] + 2*Blue[i][j] + Blue[i+1][j] + 0*Blue[i][j] + 0*Blue[i][j] + 0*Blue[i+1][j] + (-1)*Blue[i][j+1] + (-2)*Blue[i][j+1] + (-1)*Blue[i+1][j+1]);
              }else if(i == width-1 && j == 0){
                gx_r = (Red[i-1][j] + 0*Red[i][j] + (-1)*Red[i][j] + 2*Red[i-1][j] + 0*Red[i][j] + (-2)*Red[i][j] + Red[i-1][j+1] + 0*Red[i][j+1] + (-1)*Red[i][j+1]); 
                gx_g = (Green[i-1][j] + 0*Green[i][j] + (-1)*Green[i][j] + 2*Green[i-1][j] + 0*Green[i][j] + (-2)*Green[i][j] + Green[i-1][j+1] + 0*Green[i][j+1] + (-1)*Green[i][j+1]); 
                gx_b = (Blue[i-1][j] + 0*Blue[i][j] + (-1)*Blue[i][j] + 2*Blue[i-1][j] + 0*Blue[i][j] + (-2)*Blue[i][j] + Blue[i-1][j+1] + 0*Blue[i][j+1] + (-1)*Blue[i][j+1]); 
                gy_r = (Red[i-1][j] + 2*Red[i][j] + Red[i][j] + 0*Red[i-1][j] + 0*Red[i][j] + 0*Red[i][j] + (-1)*Red[i-1][j+1] + (-2)*Red[i][j+1] + (-1)*Red[i][j+1]); 
                gy_g = (Green[i-1][j] + 2*Green[i][j] + Green[i][j] + 0*Green[i-1][j] + 0*Green[i][j] + 0*Green[i][j] + (-1)*Green[i-1][j+1] + (-2)*Green[i][j+1] + (-1)*Green[i][j+1]); 
                gy_b = (Blue[i-1][j] + 2*Blue[i][j] + Blue[i][j] + 0*Blue[i-1][j] + 0*Blue[i][j] + 0*Blue[i][j] + (-1)*Blue[i-1][j+1] + (-2)*Blue[i][j+1] + (-1)*Blue[i][j+1]); 
              }else if(i == 0 && j == height -1){
                gx_r = (Red[i][j-1] + 0*Red[i][j-1] + (-1)*Red[i+1][j-1] + 2*Red[i][j] + 0*Red[i][j] + (-2)*Red[i+1][j] + Red[i][j] + 0*Red[i][j] + (-1)*Red[i+1][j]);
                gx_g = (Green[i][j-1] + 0*Green[i][j-1] + (-1)*Green[i+1][j-1] + 2*Green[i][j] + 0*Green[i][j] + (-2)*Green[i+1][j] + Green[i][j] + 0*Green[i][j] + (-1)*Green[i+1][j]);
                gx_b = (Blue[i][j-1] + 0*Blue[i][j-1] + (-1)*Blue[i+1][j-1] + 2*Blue[i][j] + 0*Blue[i][j] + (-2)*Blue[i+1][j] + Blue[i][j] + 0*Blue[i][j] + (-1)*Blue[i+1][j]);
                gy_r = (Red[i][j-1] + 2*Red[i][j-1] + Red[i+1][j-1] + 0*Red[i][j] + 0*Red[i][j] + 0*Red[i+1][j] + (-1)*Red[i][j] + (-2)*Red[i][j] + (-1)*Red[i+1][j]);
                gy_g = (Green[i][j-1] + 2*Green[i][j-1] + Green[i+1][j-1] + 0*Green[i][j] + 0*Green[i][j] + 0*Green[i+1][j] + (-1)*Green[i][j] + (-2)*Green[i][j] + (-1)*Green[i+1][j]);
                gy_b = (Blue[i][j-1] + 2*Blue[i][j-1] + Blue[i+1][j-1] + 0*Blue[i][j] + 0*Blue[i][j] + 0*Blue[i+1][j] + (-1)*Blue[i][j] + (-2)*Blue[i][j] + (-1)*Blue[i+1][j]);
              }else if(i == width-1 && j == height - 1){
                gx_r = (Red[i-1][j-1] + 0*Red[i][j-1] + (-1)*Red[i][j-1] + 2*Red[i-1][j] + 0*Red[i][j] + (-2)*Red[i][j] + Red[i-1][j] + 0*Red[i][j] + (-1)*Red[i][j]);
                gx_g = (Green[i-1][j-1] + 0*Green[i][j-1] + (-1)*Green[i][j-1] + 2*Green[i-1][j] + 0*Green[i][j] + (-2)*Green[i][j] + Green[i-1][j] + 0*Green[i][j] + (-1)*Green[i][j]);
                gx_b = (Blue[i-1][j-1] + 0*Blue[i][j-1] + (-1)*Blue[i][j-1] + 2*Blue[i-1][j] + 0*Blue[i][j] + (-2)*Blue[i][j] + Blue[i-1][j] + 0*Blue[i][j] + (-1)*Blue[i][j]);
                gy_r = (Red[i-1][j-1] + 2*Red[i][j-1] + Red[i][j-1] + 0*Red[i-1][j] + 0*Red[i][j] + 0*Red[i][j] + (-1)*Red[i-1][j] + (-2)*Red[i][j] + (-1)*Red[i][j]);
                gy_g = (Green[i-1][j-1] + 2*Green[i][j-1] + Green[i][j-1] + 0*Green[i-1][j] + 0*Green[i][j] + 0*Green[i][j] + (-1)*Green[i-1][j] + (-2)*Green[i][j] + (-1)*Green[i][j]);
                gy_b = (Blue[i-1][j-1] + 2*Blue[i][j-1] + Blue[i][j-1] + 0*Blue[i-1][j] + 0*Blue[i][j] + 0*Blue[i][j] + (-1)*Blue[i-1][j] + (-2)*Blue[i][j] + (-1)*Blue[i][j]);
              }else if(j == 0){
                gx_r = (Red[i-1][j] + 0*Red[i][j] + (-1)*Red[i+1][j] + 2*Red[i-1][j] + 0*Red[i][j] + (-2)*Red[i+1][j] + Red[i-1][j+1] + 0*Red[i][j+1] + (-1)*Red[i+1][j+1]);
                gx_g = (Green[i-1][j] + 0*Green[i][j] + (-1)*Green[i+1][j] + 2*Green[i-1][j] + 0*Green[i][j] + (-2)*Green[i+1][j] + Green[i-1][j+1] + 0*Green[i][j+1] + (-1)*Green[i+1][j+1]);
                gx_b = (Blue[i-1][j] + 0*Blue[i][j] + (-1)*Blue[i+1][j] + 2*Blue[i-1][j] + 0*Blue[i][j] + (-2)*Blue[i+1][j] + Blue[i-1][j+1] + 0*Blue[i][j+1] + (-1)*Blue[i+1][j+1]);
                gy_r = (Red[i-1][j] + 2*Red[i][j] + Red[i+1][j] + 0*Red[i-1][j] + 0*Red[i][j] + 0*Red[i+1][j] + (-1)*Red[i-1][j+1] + (-2)*Red[i][j+1] + (-1)*Red[i+1][j+1]);
                gy_g = (Green[i-1][j] + 2*Green[i][j] + Green[i+1][j] + 0*Green[i-1][j] + 0*Green[i][j] + 0*Green[i+1][j] + (-1)*Green[i-1][j+1] + (-2)*Green[i][j+1] + (-1)*Green[i+1][j+1]);
                gy_b = (Blue[i-1][j] + 2*Blue[i][j] + Blue[i+1][j] + 0*Blue[i-1][j] + 0*Blue[i][j] + 0*Blue[i+1][j] + (-1)*Blue[i-1][j+1] + (-2)*Blue[i][j+1] + (-1)*Blue[i+1][j+1]);
              }else if(j == height-1){
                gx_r = (Red[i-1][j-1] + 0*Red[i][j-1] + (-1)*Red[i+1][j-1] + 2*Red[i-1][j] + 0*Red[i][j] + (-2)*Red[i+1][j]+ Red[i-1][j] + 0*Red[i][j] + (-1)*Red[i+1][j]);
                gx_g = (Green[i-1][j-1] + 0*Green[i][j-1] + (-1)*Green[i+1][j-1] + 2*Green[i-1][j] + 0*Green[i][j] + (-2)*Green[i+1][j]+ Green[i-1][j] + 0*Green[i][j] + (-1)*Green[i+1][j]);
                gx_b = (Blue[i-1][j-1] + 0*Blue[i][j-1] + (-1)*Blue[i+1][j-1] + 2*Blue[i-1][j] + 0*Blue[i][j] + (-2)*Blue[i+1][j]+ Blue[i-1][j] + 0*Blue[i][j] + (-1)*Blue[i+1][j]);
                gy_r = (Red[i-1][j-1] + 2*Red[i][j-1] + Red[i+1][j-1] + 0*Red[i-1][j] + 0*Red[i][j] + 0*Red[i+1][j]+ (-1)*Red[i-1][j] + (-2)*Red[i][j] + (-1)*Red[i+1][j]);
                gy_g = (Green[i-1][j-1] + 2*Green[i][j-1] + Green[i+1][j-1] + 0*Green[i-1][j] + 0*Green[i][j] + 0*Green[i+1][j]+ (-1)*Green[i-1][j] + (-2)*Green[i][j] + (-1)*Green[i+1][j]);
                gy_b = (Blue[i-1][j-1] + 2*Blue[i][j-1] + Blue[i+1][j-1] + 0*Blue[i-1][j] + 0*Blue[i][j] + 0*Blue[i+1][j]+ (-1)*Blue[i-1][j] + (-2)*Blue[i][j] + (-1)*Blue[i+1][j]);
              }else if(i == 0){
                gx_r = (Red[i][j-1] + 0*Red[i][j-1] + (-1)*Red[i+1][j-1] + 2*Red[i][j] + 0*Red[i][j] + (-2)*Red[i+1][j] + Red[i][j+1] + 0*Red[i][j+1] + (-1)*Red[i+1][j+1]);
                gx_g = (Green[i][j-1] + 0*Green[i][j-1] + (-1)*Green[i+1][j-1] + 2*Green[i][j] + 0*Green[i][j] + (-2)*Green[i+1][j] + Green[i][j+1] + 0*Green[i][j+1] + (-1)*Green[i+1][j+1]);
                gx_b = (Blue[i][j-1] + 0*Blue[i][j-1] + (-1)*Blue[i+1][j-1] + 2*Blue[i][j] + 0*Blue[i][j] + (-2)*Blue[i+1][j] + Blue[i][j+1] + 0*Blue[i][j+1] + (-1)*Blue[i+1][j+1]);
                gy_r = (Red[i][j-1] + 2*Red[i][j-1] + Red[i+1][j-1] + 0*Red[i][j] + 0*Red[i][j] + 0*Red[i+1][j] + (-1)*Red[i][j+1] + (-2)*Red[i][j+1] + (-1)*Red[i+1][j+1]);
                gy_g = (Green[i][j-1] + 2*Green[i][j-1] + Green[i+1][j-1] + 0*Green[i][j] + 0*Green[i][j] + 0*Green[i+1][j] + (-1)*Green[i][j+1] + (-2)*Green[i][j+1] + (-1)*Green[i+1][j+1]);
                gy_b = (Blue[i][j-1] + 2*Blue[i][j-1] + Blue[i+1][j-1] + 0*Blue[i][j] + 0*Blue[i][j] + 0*Blue[i+1][j] + (-1)*Blue[i][j+1] + (-2)*Blue[i][j+1] + (-1)*Blue[i+1][j+1]);
              }else if(i == width-1){
                gx_r = (Red[i-1][j-1] + 0*Red[i][j-1] + (-1)*Red[i][j-1] + 2*Red[i-1][j] + 0*Red[i][j] + (-2)*Red[i][j] + Red[i-1][j+1] + 0*Red[i][j+1] + (-1)*Red[i][j+1]);
                gx_g = (Green[i-1][j-1] + 0*Green[i][j-1] + (-1)*Green[i][j-1] + 2*Green[i-1][j] + 0*Green[i][j] + (-2)*Green[i][j] + Green[i-1][j+1] + 0*Green[i][j+1] + (-1)*Green[i][j+1]);
                gx_b = (Blue[i-1][j-1] + 0*Blue[i][j-1] + (-1)*Blue[i][j-1] + 2*Blue[i-1][j] + 0*Blue[i][j] + (-2)*Blue[i][j] + Blue[i-1][j+1] + 0*Blue[i][j+1] + (-1)*Blue[i][j+1]);
                gy_r = (Red[i-1][j-1] + 2*Red[i][j-1] + Red[i][j-1] + 0*Red[i-1][j] + 0*Red[i][j] + 0*Red[i][j] + (-1)*Red[i-1][j+1] + (-2)*Red[i][j+1] + (-1)*Red[i][j+1]);
                gy_g = (Green[i-1][j-1] + 2*Green[i][j-1] + Green[i][j-1] + 0*Green[i-1][j] + 0*Green[i][j] + 0*Green[i][j] + (-1)*Green[i-1][j+1] + (-2)*Green[i][j+1] + (-1)*Green[i][j+1]);
                gy_b = (Blue[i-1][j-1] + 2*Blue[i][j-1] + Blue[i][j-1] + 0*Blue[i-1][j] + 0*Blue[i][j] + 0*Blue[i][j] + (-1)*Blue[i-1][j+1] + (-2)*Blue[i][j+1] + (-1)*Blue[i][j+1]);
              }else{
                gx_r = (Red[i-1][j-1] + 0*Red[i][j-1] + (-1)*Red[i+1][j-1] + 2*Red[i-1][j] + 0*Red[i][j] + (-2)*Red[i+1][j] + Red[i-1][j+1] + 0*Red[i][j+1] + (-1)*Red[i+1][j+1]);
                gx_g = (Green[i-1][j-1] + 0*Green[i][j-1] + (-1)*Green[i+1][j-1] + 2*Green[i-1][j] + 0*Green[i][j] + (-2)*Green[i+1][j] + Green[i-1][j+1] + 0*Green[i][j+1] + (-1)*Green[i+1][j+1]);
                gx_b = (Blue[i-1][j-1] + 0*Blue[i][j-1] + (-1)*Blue[i+1][j-1] + 2*Blue[i-1][j] + 0*Blue[i][j] + (-2)*Blue[i+1][j] + Blue[i-1][j+1] + 0*Blue[i][j+1] + (-1)*Blue[i+1][j+1]);
                gy_r = (Red[i-1][j-1] + 2*Red[i][j-1] + Red[i+1][j-1] + 0*Red[i-1][j] + 0*Red[i][j] + 0*Red[i+1][j] + (-1)*Red[i-1][j+1] + (-2)*Red[i][j+1] + (-1)*Red[i+1][j+1]);
                gy_g = (Green[i-1][j-1] + 2*Green[i][j-1] + Green[i+1][j-1] + 0*Green[i-1][j] + 0*Green[i][j] + 0*Green[i+1][j] + (-1)*Green[i-1][j+1] + (-2)*Green[i][j+1] + (-1)*Green[i+1][j+1]);
                gy_b = (Blue[i-1][j-1] + 2*Blue[i][j-1] + Blue[i+1][j-1] + 0*Blue[i-1][j] + 0*Blue[i][j] + 0*Blue[i+1][j] + (-1)*Blue[i-1][j+1] + (-2)*Blue[i][j+1] + (-1)*Blue[i+1][j+1]);
              }
    		  energy = gx_r*gx_r + gy_r*gy_r + gx_g*gx_g + gy_g* gy_g + gx_b*gx_b + gy_b*gy_b;
    		  mag = mag2gray(energy);
              img.setPixel(i, j, mag, mag, mag);
    	  }
      }
      return img;
    // Don't forget to use the method mag2gray() above to convert energies to
    // pixel intensities.
  }


  private static void doTest(boolean b, String msg) {
    if (b) {
      System.out.println("Good.");
    } else {
      System.err.println(msg);
    }
  }

  
  private static PixImage array2PixImage(int[][] pixels) {
    int width = pixels.length;
    int height = pixels[0].length;
    PixImage image = new PixImage(width, height);

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        image.setPixel(x, y, (short) pixels[x][y], (short) pixels[x][y],
                       (short) pixels[x][y]);
      }
    }

    return image;
  }

  
  public boolean equals(PixImage image) {
    int width = getWidth();
    int height = getHeight();

    if (image == null ||
        width != image.getWidth() || height != image.getHeight()) {
      return false;
    }

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        if (! (getRed(x, y) == image.getRed(x, y) &&
               getGreen(x, y) == image.getGreen(x, y) &&
               getBlue(x, y) == image.getBlue(x, y))) {
          return false;
        }
      }
    }
    return true;
  }

  
  public static void main(String[] args) {
    
    PixImage image1 = array2PixImage(new int[][] { { 0, 10, 240 },
                                                   { 30, 120, 250 },
                                                   { 80, 250, 255 } });
    System.out.println("Testing getWidth/getHeight on a 3x3 image.  " +
                       "Input image:");
    System.out.print(image1);
    doTest(image1.getWidth() == 3 && image1.getHeight() == 3,
           "Incorrect image width and height.");

    System.out.println("Testing blurring on a 3x3 image.");
    doTest(image1.boxBlur(1).equals(
           array2PixImage(new int[][] { { 40, 108, 155 },
                                        { 81, 137, 187 },
                                        { 120, 164, 218 } })),
           "Incorrect box blur (1 rep):\n" + image1.boxBlur(1));
    doTest(image1.boxBlur(2).equals(
           array2PixImage(new int[][] { { 91, 118, 146 },
                                        { 108, 134, 161 },
                                        { 125, 151, 176 } })),
           "Incorrect box blur (2 rep):\n" + image1.boxBlur(2));
    doTest(image1.boxBlur(2).equals(image1.boxBlur(1).boxBlur(1)),
           "Incorrect box blur (1 rep + 1 rep):\n" +
           image1.boxBlur(2) + image1.boxBlur(1).boxBlur(1));

    System.out.println("Testing edge detection on a 3x3 image.");
    doTest(image1.sobelEdges().equals(
           array2PixImage(new int[][] { { 104, 189, 180 },
                                        { 160, 193, 157 },
                                        { 166, 178, 96 } })),
           "Incorrect Sobel:\n" + image1.sobelEdges());


    PixImage image2 = array2PixImage(new int[][] { { 0, 100, 100 },
                                                   { 0, 0, 100 } });
    System.out.println("Testing getWidth/getHeight on a 2x3 image.  " +
                       "Input image:");
    System.out.print(image2);
    doTest(image2.getWidth() == 2 && image2.getHeight() == 3,
           "Incorrect image width and height.");

    System.out.println("Testing blurring on a 2x3 image.");
    doTest(image2.boxBlur(1).equals(
           array2PixImage(new int[][] { { 25, 50, 75 },
                                        { 25, 50, 75 } })),
           "Incorrect box blur (1 rep):\n" + image2.boxBlur(1));

    System.out.println("Testing edge detection on a 2x3 image.");
    doTest(image2.sobelEdges().equals(
           array2PixImage(new int[][] { { 122, 143, 74 },
                                        { 74, 143, 122 } })),
           "Incorrect Sobel:\n" + image2.sobelEdges());
  }
}
