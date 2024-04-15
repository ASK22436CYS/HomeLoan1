package com.homeloan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.homeloan.beans.LoanEntity;
import com.homeloan.dao.LoanRepository;
import com.homeloan.service.LoanServiceImpl;

@ExtendWith(MockitoExtension.class)
class LoanServiceImplTest {

	@Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanServiceImpl loanService;

    @Test
    public void testSaveEntity() {
        LoanEntity loanEntity = new LoanEntity();
        when(loanRepository.save(loanEntity)).thenReturn(loanEntity);

        LoanEntity savedEntity = loanService.saveEntity(loanEntity);

        assertEquals(loanEntity, savedEntity);
        verify(loanRepository, times(1)).save(loanEntity);
    }

    @Test
    public void testGetByUserId() {
        int userId = 1;
        List<LoanEntity> loanEntities = new ArrayList<>();
        when(loanRepository.findByUserId(userId)).thenReturn(loanEntities);

        List<LoanEntity> result = loanService.getbyUserId(userId);

        assertEquals(loanEntities, result);
        verify(loanRepository, times(1)).findByUserId(userId);
    }

    @Test
    public void testGetLoanEntity() {
        int userId = 1;
        int loanId = 1;
        LoanEntity loanEntity = new LoanEntity();
        when(loanRepository.getLoanEntity(userId, loanId)).thenReturn(loanEntity);

        LoanEntity result = loanService.getLoanentity(userId, loanId);

        assertEquals(loanEntity, result);
        verify(loanRepository, times(1)).getLoanEntity(userId, loanId);
    }

}
