package unitTests;

import DesignPatternsProject.DTO.DTOConverter;
import DesignPatternsProject.DTO.PersonDTOInfo;
import DesignPatternsProject.DTO.PersonFormDTO;
import DesignPatternsProject.resources.PersonResource;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lucjan on 08.06.15.
 */
public class DTOTest {

    @Test
    public void personDTOTest() {
        PersonFormDTO personFormDTO = DTOConverter.toPersonFormDTO(PersonResource.getDatabaseDeveloperAdrianKrawiec());

//        Assert.assertEquals(PersonResource.getDatabaseDeveloperAdrianKrawiec(), DTOConverter.toPerson(personFormDTO));
        PersonDTOInfo personDTOInfo = DTOConverter.toPersonDTOInfo(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        Assert.assertNotNull(personDTOInfo);

        Assert.assertEquals(personDTOInfo.getId(), PersonResource.getDatabaseDeveloperAdrianKrawiec().getId());
        Assert.assertEquals(personDTOInfo.getUsername(), PersonResource.getDatabaseDeveloperAdrianKrawiec().getUsername());
        Assert.assertEquals(personDTOInfo.getPassword(), PersonResource.getDatabaseDeveloperAdrianKrawiec().getPassword());
        Assert.assertEquals(personDTOInfo.getName(), PersonResource.getDatabaseDeveloperAdrianKrawiec().getPersonality().getName());
        Assert.assertEquals(personDTOInfo.getName(), PersonResource.getDatabaseDeveloperAdrianKrawiec().getPersonality().getName());
        Assert.assertEquals(personDTOInfo.getName(), PersonResource.getDatabaseDeveloperAdrianKrawiec().getPersonality().getName());

    }

}
