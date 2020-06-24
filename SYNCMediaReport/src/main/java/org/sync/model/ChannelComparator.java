package org.sync.model;

import java.util.Comparator;

public class ChannelComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
    Channel c1=(Channel)o1;
    Channel c2=(Channel)o2;
		return c1.getStreamname().compareTo(c2.getStreamname());
	}

}
