import java.util.*;
public class Mobile
{
    private Contact contact;
    private List<Contact> contactList;

    public Mobile()
    {
        this.contactList = new ArrayList<>();
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void addContact (Contact contact)
    {
        if (contactList.contains(contact))
        {
            System.out.println("Number already present in contact list");
        }
        else {
            contactList.add(contact);
            System.out.println("Add contact");
        }
    }

    public void removeContact (Contact contact)
    {
        if (contactList.contains(contact))
        {
            contactList.remove(contact);
            System.out.println("Contact deleted successfully");
        }
        else
        {
            System.out.println("Contact not found");
        }
    }


    public void searchContact (Contact contact)
    {
        boolean flag = false;
        for (int i=0; i<contactList.size(); i++)
        {
            if (contactList.get(i).getName().toLowerCase().equals(contact.getName().toLowerCase()))
            {
                flag = true;
                System.out.println("Name : "+contactList.get(i).getName()+"   Contact no. : "+contactList.get(i).getNo());
            }
        }
        if (!flag)
        {
            System.out.println("Contact not found");
        }
    }

    public void displayList ()
    {
        for (Contact contact : contactList)
        {
            System.out.println(contact);
        }
    }

    public void sortContactList()
    {
        contactList.sort(Comparator.naturalOrder());
    }

    public void binarySearch(Contact contact)
    {
        sortContactList();
        int index = Collections.binarySearch(contactList, contact);
        if (index >= 0)
        {
            System.out.println("Contact "+contact+" is at position "+(index+1));
        }
        else {
            System.out.println("Contact "+contact+" is not present");
        }
    }
}
