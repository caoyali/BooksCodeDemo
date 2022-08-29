获取context
```java
public class BaseTest {
    protected Context mAppContext;
    @Before
    public void before() {
        mAppContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }
    @After
    public void after() {

    }
}

```

对于测试异步流程

用 CountDownLatch 这个类。数值写成1，应该就能完成很多步骤串行的流程。