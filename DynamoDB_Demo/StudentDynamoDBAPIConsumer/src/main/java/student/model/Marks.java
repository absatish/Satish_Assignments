package student.model;

public class Marks {

		int rollNumber;
		int Telugu;
		int Hindi;
		int English;
		int Maths;
		int Science;
		int Social;
		
		public Marks() {
			super();
		}
		public Marks(int rollNumber, int telugu, int hindi, int english, int maths, int science, int social) {
			super();
			this.rollNumber = rollNumber;
			Telugu = telugu;
			Hindi = hindi;
			English = english;
			Maths = maths;
			Science = science;
			Social = social;
		}
		
		public int getRollNumber() {
			return rollNumber;
		}
		public void setRollNumber(int rollNumber) {
			this.rollNumber = rollNumber;
		}
		
		public int getTelugu() {
			return Telugu;
		}
		public void setTelugu(int telugu) {
			Telugu = telugu;
		}
		
		public int getHindi() {
			return Hindi;
		}
		public void setHindi(int hindi) {
			Hindi = hindi;
		}
		
		public int getEnglish() {
			return English;
		}
		public void setEnglish(int english) {
			English = english;
		}
		
		public int getMaths() {
			return Maths;
		}
		public void setMaths(int maths) {
			Maths = maths;
		}
		
		public int getScience() {
			return Science;
		}
		public void setScience(int science) {
			Science = science;
		}
		
		public int getSocial() {
			return Social;
		}
		public void setSocial(int social) {
			Social = social;
		}

}
