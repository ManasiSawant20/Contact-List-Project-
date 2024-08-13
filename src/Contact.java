public class Contact implements Comparable<Contact>{
    private String name;
    private String no;

    public Contact (String name, String no)
    {
        this.name = name;
        this.no = no;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setNo(String no)
    {
        this.no = no;
    }

    public String getNo()
    {
        return no;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", no='" + no + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
        {
            return true;
        }
        if(obj instanceof Contact contact)
        {
            return contact.getNo().equals(this.no);
        }
        return false;
    }

    @Override
    public int compareTo(Contact o) {
        return this.getName().compareTo(o.getName());
    }
}
