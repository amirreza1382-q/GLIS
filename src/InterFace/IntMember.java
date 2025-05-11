package InterFace;

import java.io.FileNotFoundException;

import Common.Member;

public interface IntMember <B> {
    public void insert(B a);
    public B split(String a);
    public B[] SelectAll() throws FileNotFoundException;
    public B[] searchfood(String s) throws FileNotFoundException;
    public void Deletmember(int rowmember) throws FileNotFoundException;
    public void updateMember(String newmember, B  updatedMember) throws FileNotFoundException;
}
