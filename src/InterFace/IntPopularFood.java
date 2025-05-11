package InterFace;

import java.util.List;

public interface IntPopularFood <B> {
        public void addOrUpdatePopularFood(String foodName);
        public B searchPopularFood(String foodName);
        public void removePopularFood(String foodName);
        public List<B> getPopularFoods();
        public void printPopularFoods();
          

}
