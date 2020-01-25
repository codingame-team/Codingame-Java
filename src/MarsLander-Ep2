import java.util.*;
import java.io.*;
import java.math.*;

class Util {
	static Random r = new Random() ;

	/*
	 * retourne un entier aléatoire entre a et b inclus
	 */
	static int random(int a, int b) {
		return a + r.nextInt(b - a) ;
	}
	
	static float random() {
		return r.nextFloat() ;
	}
	
	/*
	 * vérifie l'intersection entre deux segments
	 */
	static boolean intersection(Point P1, Vecteur V1,Point P2,Vecteur V2){
		double denom = V1.VecteurY * V2.VecteurX - V1.VecteurX * V2.VecteurY;
		double num = - V1.VecteurX * P1.y + V1.VecteurX * P2.y + V1.VecteurY*P1.x - V1.VecteurY*P2.x;
		double num2 = P1.x*V2.VecteurY - P2.x*V2.VecteurY - V2.VecteurX * P1.y + V2.VecteurX* P2.y;
		//Point intersection = new Point();
		//intersection.setLocation(P1.x + num2/denom * V1.VecteurX, P1.y + num2/denom * V1.VecteurY);
		boolean croisement=false ;
		
		if(denom == 0){
			// les droites sont parallèles
			croisement = false ;
		}
		else if(num/denom >= 0 && num2/denom >= 0 && num/denom <= 1 && num2/denom <= 1 ) {
			//croisement au niveau du segment
			croisement = true ; 
		}
		return croisement ;
	}
	
	public static int round(double d) {
	    if (d >= 0) {
	        return (int) (d + 0.5);
	    } 
	    else {
	        return (int) (d - 0.5);
	    }
	}
}

class Vecteur { //quelques fonctions de bases sur les vecteurs
	double VecteurX;
	double VecteurY;
	
	Vecteur() {
		this.VecteurX = 0;
		this.VecteurY = 0;
	}
	
	Vecteur(double VecteurX, double VecteurY){
		this.VecteurX = VecteurX;
		this.VecteurY = VecteurY;
	}
	
	Vecteur(double x1,double y1,double x2,double y2){
		VecteurX = x2 - x1;
		VecteurY = y2 - y1;
	}
	
	Vecteur(Point A, Point B){
		VecteurX = B.getX()- A.getX();
		VecteurY = B.getY()- A.getY();
	}
	
	Vecteur(Vecteur v) {
		VecteurX = v.VecteurX ;
		VecteurY = v.VecteurY ;				
	}
	
	double norme(){
		Point origine = new Point();
		return origine.distance(VecteurX,VecteurY);
	}
	
	Vecteur addition(Vecteur V2) {
		return new Vecteur(this.VecteurX + V2.VecteurX,this.VecteurY + V2.VecteurY);
	}
	
	Vecteur multiplication(double k){
		return new Vecteur(k * this.VecteurX, k * this.VecteurY) ;
	}
	
	Vecteur rotation(double angle){
		Vecteur retour = new Vecteur(0,0) ;
		retour.VecteurX = VecteurX * Math.cos(Math.toRadians(angle)) - VecteurY * Math.sin(Math.toRadians(angle));
		retour.VecteurY = VecteurX * Math.sin(Math.toRadians(angle)) + VecteurY * Math.cos(Math.toRadians(angle));
		return retour;
	}
	
	double determinant(Vecteur V2){
		return VecteurX*V2.VecteurY - VecteurY * V2.VecteurX ;
	}
	
	double scalaire(Vecteur V2){//produit scalaire
		return this.VecteurX * V2.VecteurX + this.VecteurY * V2.VecteurY ;
	}
	
	double angleVecteurs(Vecteur V2){
		//V1 scalaire V2 = Cos(angle) * norme(V1) * norme V2
		double cosinus, angle;
		//renvoie un angle entre 0 et 180 
		if(this.norme()!=0 && V2.norme()!=0){
			cosinus = this.scalaire(V2)/(this.norme()*V2.norme());
			angle = Math.toDegrees(Math.acos(cosinus));
			
			//pour le sens, on utilise le déterminant (positif si angle entre 0 et 180, négatif sinon
			double det = this.determinant(V2) ;
			if(det<0) {
			angle = -angle;
			}
		}
		else {
			angle = 0;
		}

		return angle ;
	}
	
	Vecteur vnormal() {
		return this.multiplication(1/this.norme()) ;
	}
	
	static Vecteur vnormal(Point a, Point b) {
		Vecteur v = new Vecteur(a,b) ;
		return v.multiplication(1/v.norme()) ;
	}
	
}


class Point {
	double x;
	double y;
	
	Point() {
		x = 0d;
		y = 0d;
	}
	Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	Point(Point p){
		this.x = p.x ;
		this.y = p.y ;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	double distanceSq(Point p) {
		return (p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y) ;
	}
	double distanceSq(double x, double y){
		return this.distanceSq(new Point(x,y)) ;
	}
	double distance(Point p){
		return Math.sqrt(this.distanceSq(p));
	}
	double distance(double x, double y) {
		return this.distance(new Point(x,y)) ;
	}
	/*
	 * recherche le point le plus proche de m sur la ligne a -> b
	 */
	public Point closest(Point a, Point b) {
	    double da = b.y - a.y;
	    double db = a.x - b.x;
	    double c1 = da*a.x + db*a.y;
	    double c2 = -db*this.x + da*this.y;
	    double det = da*da + db*db;
	    double cx = 0;
	    double cy = 0;
	
	    if (det != 0) {
	        cx = (da*c1 - db*c2) / det;
	        cy = (da*c2 + db*c1) / det;
	    } else {
	        // The point is already on the line
	        cx = this.x;
	        cy = this.y;
	    }
	
	    return new Point(cx, cy);
	}
	@Override
	public String toString() {
		return x + " " + y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		return true;
	}
}

class Lander {
	private Point position ;
	private Point previousPosition ;
	private double hSpeed ;
	private double vSpeed ;
	private int fuel ;
	private int rotate ;
	private int power ;
	
    final static private double gravity = -3.711d ;

	
	public Lander(Point position, int hSpeed, int vSpeed, int fuel, int rotate, int power) {
		this.setPosition(position);
		this.sethSpeed(hSpeed);
		this.setvSpeed(vSpeed);
		this.setFuel(fuel);
		this.setRotate(rotate);
		this.setPower(power) ;
		previousPosition = null ;
	}
	
	public Lander(int positionx, int positiony, int hSpeed, int vSpeed, int fuel, int rotate, int power) {
		this.setPosition(new Point(positionx,positiony));
		this.sethSpeed(hSpeed);
		this.setvSpeed(vSpeed);
		this.setFuel(fuel);
		this.setRotate(rotate);
		this.setPower(power);
	}
	
	public Lander(Lander l) {
		previousPosition = l.getPreviousPosition() == null ? null : new Point(l.getPreviousPosition()) ;
		position = new Point(l.getPosition()) ;
		hSpeed = l.hSpeed ;
		vSpeed = l.vSpeed ;
		fuel = l.fuel ;
		rotate = l.rotate ;
		power = l.power ;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public double gethSpeed() {
		return hSpeed;
	}

	public void sethSpeed(int hSpeed) {
		this.hSpeed = hSpeed;
	}

	public double getvSpeed() {
		return vSpeed;
	}

	public void setvSpeed(int vSpeed) {
		this.vSpeed = vSpeed;
	}

	public Point getPreviousPosition() {
		return previousPosition;
	}

	public void setPreviousPosition(Point previousPosition) {
		this.previousPosition = previousPosition;
	}

	public int getFuel() {
		return fuel;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	public int getRotate() {
		return rotate;
	}

	public void setRotate(int rotate) {
		this.rotate = rotate;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
	
	void updatePosition(Move move) {
		this.previousPosition = new Point(this.position) ;
		
		//power and rotation update
		this.power += move.thrust ;
		this.rotate += move.angle ;
		
		//fuel
		this.fuel -= this.power ;
		
		double accely = this.power * Math.cos(Math.toRadians(this.rotate)) + Lander.gravity ;
		double accelx = - this.power * Math.sin(Math.toRadians(this.rotate)) ;
		
		//speed update
		this.vSpeed += accely ;
		this.hSpeed += accelx ;
		
		//position update
		this.position.x = this.position.x + this.hSpeed - 0.5d * accelx ;
		this.position.y = this.position.y + this.vSpeed - 0.5d * accely ;
	}
	
}


class Player {

    public static void main(String args[]) {
    	boolean begin = true ; 
    	Move result = null ; 
    	
        Scanner in = new Scanner(System.in);
        Game game = new Game(in) ;
        
        GeneticIA ia = new GeneticIA(game);
        // game loop
        while (true) {
        	Game g = new Game(game) ;
        	if(begin) game.readGame(in);
        	else g.readGame(in) ;
        	if(result != null) game.simulateNextTurn(result);

        	ia.setGame(game);
        	begin = false ; 

        	//BasicIA ia = new BasicIA(game);
        	Move move = ia.computeMoves() ;
        	result = move.convertToValid(game.getLander()) ;
            game.writeAction(result);
        }
    }
}

class Move {
	int angle ;
	int thrust ; 
	
	Move(int angle, int thrust) {
		this.angle = angle ;
		this.thrust = thrust ;
	}
	
	Move(Move m) {
		this.angle = m.angle ;
		this.thrust = m.thrust ;
	}
	
	/*
	 * random mutation on a move. p amplitude between 0 and 1 (max mutation)
	 */
	Move mutate(double amplitude){
		Move move = new Move(0, 0);
		
		int amin = (int) Math.max(-15, this.angle - 15 * amplitude) ;
		int amax = (int) Math.min(15, this.angle + 15 * amplitude) ;
		move.angle = (int) Util.random(amin,amax + 1) ;
		
		//int tmin = (int) Math.max(-1, this.thrust - 1 * amplitude) ;
		//int tmax = (int) Math.min(1, this.thrust + 1 * amplitude) ;
		move.thrust = Util.random(-1, 2) ;
		
		return move ;
	}
	
	/*
	 * generate a random move
	 */
	static Move randomMove() {
		Move m = new Move(0,0) ;
		m.angle = (int) Util.random(-15,16) ;
		m.thrust = Util.random(-1,2) ;
		return m;
	}
	
	/*
	 * convert a move to valid move
	 */
	Move convertToValid(Lander lander) {
		Move m = new Move(this) ;
		if(m.thrust + lander.getPower() < 0) m.thrust = 0 ;
		else if(m.thrust + lander.getPower() > 4) m.thrust = 0 ;
		
		if(m.angle + lander.getRotate() > 90) m.angle = 90 - lander.getRotate() ;
		else if(m.angle + lander.getRotate() < -90) m.angle = -90 - lander.getRotate() ;
		
		return m ;
	}

	@Override
	public String toString() {
		return (int) angle + " " + thrust ;
	}
}

class Game implements Comparable<Game>,aGame {
	private double score ;
	private Lander lander ;
	private boolean crash ;
	private boolean landed ;
    
	//surface & landing zone
	static private ArrayList<Point> surface ;
    static private int xmin = Integer.MIN_VALUE, xmax = Integer.MAX_VALUE, yland = 0;
	static private int lIndice ;
	static private double hmax = 0 ;
		
	public Game(Scanner in) {
		setLander(null) ;
		score = 0 ;
		crash = false ;
		landed = false ;
		surface = new ArrayList<>();
		
		int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
		for (int i = 0; i < surfaceN; i++) {
			surface.add(new Point(in.nextInt(),in.nextInt()));
	        if(i > 0) {
	        	if(surface.get(i).y > hmax) hmax = surface.get(i).y ;
	        	
	        	if(surface.get(i).y == surface.get(i-1).y) {
	                    setXmin((int) surface.get(i-1).x) ;
	                    setXmax((int) surface.get(i).x) ;
	                    setYland((int) surface.get(i).y) ;
	                    setlIndice(i) ;
	             }
	        }	
		}
	}
	
	void readGame(Scanner in) {
		setLander(new Lander(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(),in.nextInt()));
		if(lander.getPosition().y - 100 > hmax) hmax = 0 ;
	}
	
	public Game(Game g) {
		score = g.score ;
		lander = g.lander==null ? null : new Lander(g.lander) ;
		crash = g.crash ;
		landed = g.landed ;
	}

	public double getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getXmin() {
		return xmin;
	}

	public void setXmin(int xmin) {
		Game.xmin = xmin;
	}

	public int getXmax() {
		return xmax;
	}

	public void setXmax(int xmax) {
		Game.xmax = xmax;
	}

	public int getYland() {
		return yland;
	}

	public void setYland(int yland) {
		Game.yland = yland;
	}

	public Lander getLander() {
		return lander;
	}

	public void setLander(Lander lander) {
		this.lander = lander;
	}

	public static int getlIndice() {
		return lIndice;
	}

	public static void setlIndice(int lIndice) {
		Game.lIndice = lIndice;
	}

	@Override
	public int compareTo(Game arg0) {
		return Double.compare(this.score,arg0.score) ;
	}
	
	/*
	 * retourne le score correspondant à une partie
	 */
	public double evalGame() {
		if(landed && ! crash) {
			//success
			score = 100000 + this.lander.getFuel() ;
			return score ;
		}
		else if(landed && crash) {
			//crash on landing zone
			score = (-20000 - 10 * Math.max(0,Math.abs(lander.getvSpeed()) - 40)
					- 5 * Math.max(0,Math.abs(lander.gethSpeed()) - 20) 
					- Math.abs(lander.getRotate())) ;
			return score ;
		}
		else {
			//crash outside zone or not landed
			score = (-100000 
					+ 100 * Math.min(500,(this.lander.getPosition().y - hmax)) 
					- 0.5 * this.lander.getPosition().distance(surface.get(lIndice))
					- 0.5 * this.lander.getPosition().distance(surface.get(lIndice -1))
					//- Math.abs(lander.getRotate())
					- 10 * Math.max(0,Math.abs(lander.getvSpeed()) - 40)
					- 5 * Math.max(0,Math.abs(lander.gethSpeed()) - 20)
					);
			return score ;
		}
	}
	
	/*
	 * simule un tour de jeu
	 */
	public void simulateNextTurn(Move move) {
		if(this.crash || this.landed) return ;
		
		this.lander.updatePosition(move);
		Point pp = new Point(Util.round(lander.getPreviousPosition().x),Util.round(lander.getPreviousPosition().y)) ;
		Point cp = new Point(Util.round(lander.getPosition().x),Util.round(lander.getPosition().y)) ;
	
		Vecteur VP = new Vecteur(pp,cp) ;
		
		//landing or crash detection
		for(int i = 1 ; i < surface.size() ; i++) {
			Point p1 = surface.get(i -1) ;
			Point p2 = surface.get(i) ;
			Vecteur VT = new Vecteur(p1,p2) ;
			
			if(lander.getFuel() <= 0) {
				crash = true ;
				return ;
			}
			if(lander.getPosition().x < 0 || lander.getPosition().x > 7000 || lander.getPosition().y < 0 || lander.getPosition().y > 3000) {
				crash = true ;
				return ;
			}
			
			boolean choc = Util.intersection(pp, VP, p1, VT) ;
			if(!choc) {
				continue ;
			}
			else if(i != Game.lIndice) {
				//crash
				crash = true ;
			}
			else if(Math.abs(lander.getvSpeed()) <= 40 && Math.abs(lander.gethSpeed()) <= 20 && lander.getRotate() == 0) {
				//Successful landing
				landed = true ;
			}
			else {
				//Landing zone but bad speed/angle
				crash = true ; 
				landed = true ;
			}
		}
	}
	
	public void writeAction(Move move) {
		int angle = move.angle + this.lander.getRotate() ;
		int thrust = move.thrust + this.lander.getPower() ;
		
		System.out.println(angle + " " + thrust);
	}
}

class Solution implements Comparable<Solution> {
	final static int LENGTH = 100 ;
	final static float MUTATION_PROB = 0.1f ;
	
	double score ;
	Move[] solution ;


	public Solution() {
		score = 0 ;
		this.solution = new Move[LENGTH];
	}
	
	public Solution(Solution s){
		score = s.score ;
		solution = new Move[LENGTH] ;
		System.arraycopy(s.solution, 0, this.solution, 0, LENGTH);
	}

	@Override
	public String toString() {
		return "Solution [score=" + score + ", solution=" + Arrays.toString(solution) + "]";
	}
	
	double score(Game g) {
		Game game = new Game(g);
		
		for(int i = 0 ; i < LENGTH ; i++) {
			Move m = solution[i] ;
			//System.err.println("m " + m.toString());
			game.simulateNextTurn(m.convertToValid(game.getLander()));
		}
		
		score = game.evalGame() ;

		return score ;
	}
	
	@Override
	public int compareTo(Solution arg0) {
		return Double.compare(this.score,arg0.score) ;
	}
	
	/*
	 * create a random solution
	 */
	static Solution randomSolution() {
		Solution s = new Solution() ;
		
		for(int i = 0 ; i < LENGTH ; i++) {
			s.solution[i] = Move.randomMove() ;
		}
		return s ;
	}
	
	/*
	 * Random mutation on a solution
	 */
	void mutate(double amplitude) {		
		//si le tirage aléatoire est ok, on mute le gène de manière aléatoire
		for(int i = 0 ; i < Solution.LENGTH ; i++){
			if(Util.random() <= MUTATION_PROB) solution[i] = solution[i].mutate(amplitude);
		}
	}
	
	/*
	 * Crossover : generate two childs from two parents solutions
	 * single point crossover  
	 * see : https://en.wikipedia.org/wiki/Crossover_(genetic_algorithm)
	 */
	 ArrayList<Solution> crossover(Solution s) {
		 int point = Util.random(0,LENGTH) ;
		 
		 Solution child1 = new Solution() ;
		 Solution child2 = new Solution() ;
		 
		 //on copie la première partie du père sur child1
		 System.arraycopy(solution, 0, child1.solution, 0, point);
		 //la suite du père est copié sur child2
		 System.arraycopy(solution, point, child2.solution, point, LENGTH - point);
		 
		 //idem avec l'autre père
		 System.arraycopy(s.solution, 0, child2.solution, 0, point);
		 System.arraycopy(s.solution, point, child1.solution, point, LENGTH - point);
		 
		 ArrayList<Solution> result = new ArrayList<>() ;
		 result.add(child1) ;
		 result.add(child2) ;
		 return result ;
	 }
	 
	 /*
	 * Crossover : generate two childs from two parents solutions
	 * n point crossover  
	 */
	 ArrayList<Solution> ncrossover(Solution s, int n) {
		 PriorityQueue<Integer> points = new PriorityQueue<>() ;
		 for(int i = 0 ; i< n ; i++) {
			 points.add(Util.random(0,LENGTH)) ;
		 }
		 points.add(LENGTH) ;
		 
		 int indice = 0 ;		 
		 boolean swap = false ;
		 Solution child1 = new Solution() ;
		 Solution child2 = new Solution() ;
		 
		 while(!points.isEmpty()) {
			int i = points.poll();
			if(swap) {
				//on copie la première partie du père sur child1
				System.arraycopy(solution, indice, child1.solution, indice, i - indice);
				//idem avec l'autre père
				System.arraycopy(s.solution, indice, child2.solution, indice, i - indice);
			}
			else {
				//on copie la première partie du père sur child1
				System.arraycopy(solution, indice, child2.solution, indice, i - indice);
				//idem avec l'autre père
				System.arraycopy(s.solution, indice, child1.solution, indice, i - indice);
			}

			indice = i ;
			swap = !swap ;
		 }
		 
		 ArrayList<Solution> result = new ArrayList<>() ;
		 result.add(child1) ;
		 result.add(child2) ;
		 return result ;
	 }
}

class BasicIA extends IA {
	//Game game ;
	
	BasicIA(Game game) {
		super(game) ;
		//this.game = game ;
	}

	@Override
	public Move computeMoves() {
		Move move = new Move(0,3) ;
        double stable = 21.913245914141 ;
 
        //positionnement au dessus de la zone            
        if(game.getLander().getPosition().x <= game.getXmin()) {
            if(game.getLander().gethSpeed() < 56) {
                move.angle = - (int) stable ;
                move.thrust = 4;
            }
            else if(game.getLander().gethSpeed() > 58) {
            	 move.angle = (int) stable ;
            	 move.thrust = 4; 
            }
            else {
            	move.thrust = game.getLander().getvSpeed() <=-1?4:1;
            }
        }
        else if(game.getLander().getPosition().x >= game.getXmax()) {
            if(game.getLander().gethSpeed() < -58) {
            	 move.angle = -(int) stable ;
            	 move.thrust = 4;
            }
            else if(game.getLander().gethSpeed() > -56) {
            	 move.angle = (int) stable ;
            	 move.thrust = 4;                    
            }
            else {
            	 move.angle = 0 ;
            	 move.thrust = game.getLander().getvSpeed()<=-1?4:1;
            }   
        }
        else {
        	move.thrust = game.getLander().getvSpeed()<=-35 || Math.abs(game.getLander().gethSpeed())>20?4:1;
            
            if(game.getYland()<500) {
                if(game.getLander().gethSpeed() <= -10)  move.angle = -45 ;
                else if(game.getLander().gethSpeed() >= 10)  move.angle = 45 ; 
                else  move.angle = 0 ;
            }
            else {
                if(game.getLander().gethSpeed() <= -20)  move.angle = -45 ;
                else if(game.getLander().gethSpeed() >= 20)  move.angle = 45 ; 
                else  move.angle = 0 ;
            }
        }
		
    Move result = new Move(0,0);
    result.angle = (int) (Math.signum(move.angle - this.game.getLander().getRotate()) * Math.min(15, Math.abs(move.angle - this.game.getLander().getRotate()))) ;
    result.thrust = (int) Math.signum(move.thrust - this.game.getLander().getPower()) ;
    
	return result ;
	}
}

class GeneticIA extends IA {
	static final long MAX_TIME = 95000000;
	static final int MAX_GENERATION = 1000 ; // max num of generation

	static final float MUTATION_PROB = 0.15f ; //probabilité de mutation
	static final float CROSSOVER_PROB = 0.9f ; //probabilité de crossover
	
	static final float ELITISM = 0.17f ; //pourcentage de population par génération
	static final float CROSSOVER = 0.85f ; //pourcentage de solution par crossover par génération
	static final int POPULATION = 31 ;//taille de la population
	
	static final boolean KEEP_PREV = true ; //keep best solution from previous turn
	static final boolean DIVERSITY = true ; //add a random solution in lowest rank from previous generation
	
	static final boolean KEEP_PREV_POP = false ; //keep previous population
	
	private long startTime ;

	Solution bestSolution ;
	ArrayList<Solution> population ;
	
	public GeneticIA(Game game) {
		super(game) ;
		startTime = System.nanoTime();
		
		bestSolution = null ;
		population = new ArrayList<>() ;
	}
	
	public void setGame(Game game) {
		this.startTime = System.nanoTime();
		this.game = game ;
	}

	boolean timeIsUp() {
		return ((System.nanoTime() - startTime - MAX_TIME) >= 0) ;
	}
	
	void generateInitialPopulation() {
		if(KEEP_PREV_POP && population.size() != 0) {
			for(int i = 0 ; i < POPULATION ; i++) {
				System.arraycopy(population.get(i).solution, 1, population.get(i).solution, 0, Solution.LENGTH - 1);
				population.get(i).solution[Solution.LENGTH - 1] = Move.randomMove() ;
			}
		}
		else {
			int OFFSET = 0 ;
			population.clear();
			
			//generate solution given by simples IA
			BasicIA bIA = new BasicIA(game);
			population.add(bIA.generateSolution(20)) ;
			OFFSET +=1 ;

			//best previous solution
			if(KEEP_PREV && bestSolution != null) {
				//remove the first move, already played and keep the rest
				System.arraycopy(bestSolution.solution, 1, bestSolution.solution, 0, Solution.LENGTH - 1);
				bestSolution.solution[Solution.LENGTH - 1] = Move.randomMove() ;
				population.add(bestSolution) ;
				OFFSET +=1 ;
			}
			//adding random solutions
			for(int i = OFFSET ; i < POPULATION ; i++) {
				population.add(Solution.randomSolution()) ;
			}
		}
	}
	
	void generateNewGeneration(double amplitude) {
		ArrayList<Solution> population = new ArrayList<>() ;
		
		//keeping the best solutions from previous iteration
		for(int i = 0 ; i < (int)(ELITISM * POPULATION) ; i++) {
			population.add(new Solution(this.population.get(this.population.size() - i - 1))) ;
		}
		
		//adding random solution at lowest position
       if(DIVERSITY) {
           if(this.population.size() < POPULATION) population.add(0, Solution.randomSolution()) ;
           else this.population.set(0, Solution.randomSolution()) ;
       }
		
		//crossover and mutation
		for(int i = 0 ; i < (int)(CROSSOVER * POPULATION) / 2 ; i++) {
			ArrayList<Solution> a = new ArrayList<>() ;
			
			if(Util.random() < CROSSOVER_PROB) {
				Solution s1 = this.uselectSolution() ;
				Solution s2 = this.uselectSolution() ;
				a.addAll(s1.ncrossover(s2,20)) ;				
			}
			else {
				a.add(this.uselectSolution());
				a.add(this.uselectSolution());
			}
			
			//mutation
			if(Util.random()<MUTATION_PROB) a.get(0).mutate(amplitude);
			if(Util.random()<MUTATION_PROB) a.get(1).mutate(amplitude);
			
			population.addAll(a);
		}

		//adding random solution for the rest
		for(int i = population.size() ; i < POPULATION ; i++) {
			population.add(Solution.randomSolution()) ;
		}

		//new population
		this.population = population ;		
	}
	
	@Override
	public Move computeMoves() {
		double amplitude = 1 ;
		int gen = 0 ; 
		
		//initial population generation
		generateInitialPopulation();
		
		//iteration
		while(!timeIsUp() && gen < MAX_GENERATION) {			
			for(Solution s:population) {
				s.score(game) ; 
			}
			Collections.sort(population);
			bestSolution = population.get(population.size() - 1) ;
			//amplitude = amplitude * 0.99d ;
			gen ++ ;
			generateNewGeneration(amplitude);
		}
		System.err.println(gen + " BestSolution " + bestSolution.solution[0].toString() + " " + bestSolution.score);
		return bestSolution.solution[0] ;
	}
	
	/*
	 * sélection des solutions en fonction de leur rang
	 * la solution de rang i a un poids i+1 (poids n = POPULATION pour la meilleure solution)
	 */
	Solution selectSolution() {
		int MAX_WEIGHT = POPULATION ;
		
		while(true) {
			int num = Util.random(0, MAX_WEIGHT) ;	
			if(Util.random() < (num+1) / MAX_WEIGHT) return this.population.get(num);
			return this.population.get(num);
		}
	}
	
	/*
	 * sélection des solutions de manière uniforme
	 */
	Solution uselectSolution() {
		return this.population.get(Util.random(0,POPULATION));
	}
}

/*
 * interface de description des IA
 */
abstract class IA {
	protected Game game ;
	
	public IA(Game game) {
		this.game = new Game(game);
	}

	public abstract Move computeMoves() ; //méthode renvoyant le mouvement à jouer
	
	//renvoie une solution calculée à partir d'une IA
	Solution generateSolution() {
		Solution s = new Solution() ;

		for(int i = 0 ; i < Solution.LENGTH ; i ++) {
			s.solution[i] = this.computeMoves() ;
			this.game.simulateNextTurn(s.solution[i]);
			//System.err.println(s.solution[i].toString());
		}
		
		return s ;
	}
	
	//renvoie une solution calculée à partir d'une IA, uniquement les n premiers mouvements
	// les mouvements suivants sont aléatoires
	Solution generateSolution(int n) {
		Solution s = new Solution() ;

		for(int i = 0 ; i < n ; i ++) {
			s.solution[i] = this.computeMoves() ;
			this.game.simulateNextTurn(s.solution[i]);
			//System.err.println(s.solution[i].toString());
		}
		for(int i = n ; i < Solution.LENGTH ; i ++) {
			s.solution[i] = Move.randomMove() ;
		}
		return s ;
	}
}

/*
 * interface de description des parties
 */
interface aGame {
	//simule une partie pour le mouvement Move
	void simulateNextTurn(Move move) ;
	//évaluation du score pour une partie
	double evalGame() ;
}
