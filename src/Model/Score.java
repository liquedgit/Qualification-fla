package Model;

public class Score implements Comparable<Score> {
	private String restaurantName;
	private Integer score;
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Score(String restaurantName, Integer score) {
		super();
		this.restaurantName = restaurantName;
		this.score = score;
	}
	@Override
	public int compareTo(Score o) {
		// TODO Auto-generated method stub
		return o.score - this.score;
	}
	
}
