package solr;

import org.apache.solr.client.solrj.beans.Field;

/**
 * Created by Fornia.fu on 2016/6/30.
 */
public class User
{
    @Field(value = "id")
    private int id;

    @Field(value = "userName")
    private String userName;

    @Field(value = "userAge")
    private int userAge;

    @Field(value = "userAddress")
    private String userAddress;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public int getUserAge()
    {
        return userAge;
    }

    public void setUserAge(int userAge)
    {
        this.userAge = userAge;
    }

    public String getUserAddress()
    {
        return userAddress;
    }

    public void setUserAddress(String userAddress)
    {
        this.userAddress = userAddress;
    }
}
