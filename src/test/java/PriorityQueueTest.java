import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
    static Stream<Arguments> stream(){
        return Stream.of(
                Arguments.of(new int[]{7, 3, 1}, new int[]{1, 3, 7}),
                Arguments.of(new int[]{7, 3, -1}, new int[]{-1, 3, 7}));
    }
    @ParameterizedTest(name = "#{index} - Test with Argument = {0}, {1}")
    @MethodSource("stream")
    void priorityQueue_Run(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
        int index = 0;
        Integer s;
        int[] result = new int[random_array.length];
        for(int i = 0; i < random_array.length;i++)
        {
            test.add(random_array[i]);
        }
        for(int i = 0; i < random_array.length;i++)
        {
            s = test.poll();
            result[i] = s;
        }
        assertArrayEquals(correct_array,result);


    }
    @Test
    public void except_null()
    {
        Exception e = assertThrows(NullPointerException.class,()->{new PriorityQueue<Integer>().add(null);});
    }
    @Test
    public void except_error()
    {
        Exception e = assertThrows(IllegalArgumentException.class,()->{new PriorityQueue<Integer>().add(null);});
    }

}