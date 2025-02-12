package recoder.testsuite.basic.analysis;

import java.util.List;

import junit.framework.Assert;
import org.junit.Test;
import recoder.abstraction.Type;
import recoder.java.reference.TypeReference;
import recoder.service.CrossReferenceSourceInfo;
import recoder.service.NameInfo;
import recoder.testsuite.basic.BasicTestsSuite;

public class TypeXReferenceCompletenessTest extends XReferenceCompletenessTest {

    @Test
    public void testTypeXReferenceCompleteness() {
        CrossReferenceSourceInfo xrsi = BasicTestsSuite.getConfig().getCrossReferenceSourceInfo();
        NameInfo ni = BasicTestsSuite.getConfig().getNameInfo();

        List<Type> types = ni.getTypes();
        for (Type x : types) {
            List<TypeReference> list = xrsi.getReferences(x);
            for (TypeReference r : list) {
                Type y = xrsi.getType(r);
                if (x != y) {
                    Assert.fail(makeResolutionError(r, x, y));
                }
            }
        }
    }
}
