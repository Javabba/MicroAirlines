package MA;



public enum TicketClassesEnum {
	
	ECONOMY,FIRSTCLASS;
	
	
	public int price() {	
		switch(this) {
		case ECONOMY:
			return 5000;
		case FIRSTCLASS:
			return 20000;
		default:
			return 0;
		}
	}
	
	
	
	
}
