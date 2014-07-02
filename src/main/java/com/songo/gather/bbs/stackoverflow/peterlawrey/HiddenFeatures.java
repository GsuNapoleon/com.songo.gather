/**
 * 
 */
package com.songo.gather.bbs.stackoverflow.peterlawrey;

/**
 * <p>decription:</p>
 * <p>date:2014年6月30日 上午10:08:50</p>
 * @author gsu·napoleon
 */
public class HiddenFeatures {
	public static void main(String[] args) {
		Rooms.NORTH.north();
	}
}

interface Room {
	Room north();
	Room south();
	Room east();
	Room west();
}
enum Rooms implements Room {
	NORTH {
		public Room north() {
			return SOUTH;
		}
	},
	SOUTH {
		public Room south() {
			return NORTH;
		}
	};

	public Room defaultRoom() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.songo.gather.bbs.stackoverflow.peterlawrey.Room#north()
	 */
	@Override
	public Room north() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.bbs.stackoverflow.peterlawrey.Room#south()
	 */
	@Override
	public Room south() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.bbs.stackoverflow.peterlawrey.Room#east()
	 */
	@Override
	public Room east() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.songo.gather.bbs.stackoverflow.peterlawrey.Room#west()
	 */
	@Override
	public Room west() {
		return null;
	}
	
}
