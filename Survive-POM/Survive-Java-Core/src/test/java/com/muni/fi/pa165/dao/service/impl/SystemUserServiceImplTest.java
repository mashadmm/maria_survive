package com.muni.fi.pa165.dao.service.impl;

import com.muni.fi.pa165.service.impl.SystemUserServiceImpl;
import com.muni.fi.pa165.dao.SystemUserDao;
import com.muni.fi.pa165.service.AbstractServiceIntegrationTest;
import com.muni.fi.pa165.dto.SystemUserDto;
import com.muni.fi.pa165.entities.Systemuser;
import javax.inject.Inject;
import org.dozer.Mapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 *
 * @author Auron
 */
public class SystemUserServiceImplTest extends AbstractServiceIntegrationTest {

    @Inject
    private SystemUserDao mockDAO;
    private SystemUserServiceImpl service;
    @Inject
    private Mapper mapper;

    @Before
    public void setUp() {
        service = new SystemUserServiceImpl();
        mockDAO = mock(SystemUserDao.class);
        service.setDao(mockDAO);
        service.setMapper(mapper);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSave() {
        SystemUserDto dto = new SystemUserDto();

        dto.setUsername("user");
        dto.setPassword("1234");
        dto.setAccessLevel(1);

        Systemuser entity = mapper.map(dto, Systemuser.class);
        when(mockDAO.save(any(Systemuser.class))).thenReturn(entity);
        SystemUserDto returned = service.save(dto);
        assertEquals(returned, dto);
    }

    /**
     * Test of update method, of class SystemUserServiceImpl.
     */
    @Test
    public void testUpdate() {
//        System.out.println("Testing update");

        SystemUserDto dto = new SystemUserDto();
        dto.setUsername("user");
        dto.setPassword("1234");
        dto.setAccessLevel(1);

        Systemuser entity = mapper.map(dto, Systemuser.class);
        when(mockDAO.update(any(Systemuser.class))).thenReturn(entity);
        SystemUserDto returned = service.update(dto);
        verify(mockDAO, times(1)).update(entity);
        verifyNoMoreInteractions(mockDAO);
        assertEquals(returned, dto);
    }

    /**
     * Test of delete method, of class SystemUserServiceImpl.
     */
    @Test
    public void testDelete() {

        SystemUserDto dto = new SystemUserDto();
        dto.setId(1L);
        dto.setUsername("user");
        dto.setPassword("1234");
        dto.setAccessLevel(1);

        Systemuser entity = mapper.map(dto, Systemuser.class);


        service.delete(dto);

        verify(mockDAO, times(1)).delete(entity);
        verifyNoMoreInteractions(mockDAO);


    }

    /**
     * Test of findById method, of class SystemUserServiceImpl.
     */
    @Test
    public void testFindById() {

        SystemUserDto dto = new SystemUserDto();

        dto.setId(1L);
        dto.setUsername("user");
        dto.setPassword("1234");
        dto.setAccessLevel(Integer.MIN_VALUE);

        Systemuser entity = mapper.map(dto, Systemuser.class);

        when(mockDAO.findById(dto.getId())).thenReturn(entity);

        SystemUserDto returned = service.findById(dto.getId());
        verify(mockDAO, times(1)).findById(dto.getId());
        verifyNoMoreInteractions(mockDAO);

        assertEquals(returned, dto);


    }
}