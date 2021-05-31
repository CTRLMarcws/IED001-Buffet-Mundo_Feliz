package model;

public class RentsNode
{
	public Rent rent;
	public RentsNode next, prev;

	public RentsNode(Rent rent)
	{
		this.rent = rent;
		this.next = null;
		this.prev = null;
	}

	public Rent getRent()
	{
		return rent;
	}

	public void setRent(Rent rent)
	{
		this.rent = rent;
	}

	public RentsNode getNext()
	{
		return next;
	}

	public void setNext(RentsNode next)
	{
		this.next = next;
	}

	public RentsNode getPrev()
	{
		return prev;
	}

	public void setPrev(RentsNode prev)
	{
		this.prev = prev;
	}
}
