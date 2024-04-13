package com.loans.money.dto.client;

import com.loans.money.dto.bill.BillMapper;
import com.loans.money.dto.bill.BillResponseDto;
import com.loans.money.dto.loan.LoanMapper;
import com.loans.money.dto.loan.LoanResponseDto;
import com.loans.money.dto.payment.PaymentMapper;
import com.loans.money.dto.payment.PaymentResponseDto;
import com.loans.money.entity.*;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

import static com.loans.money.entity.Role.VISITOR;

public class ClientMapper {
    public static Client clientDtoToClient(ClientDto clientDto){
        Client client = new Client();
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setPhone_number(clientDto.getPhone_number());
        client.setLoans_list(clientDto.getLoans_list());
        return client;
    }

    public static ClientResponseDto clientToClientResponseDto(Client client){
        ClientResponseDto clientResponseDto = new ClientResponseDto();
        clientResponseDto.setFirstName(client.getFirstName());
        clientResponseDto.setLastName(client.getLastName());
        clientResponseDto.setPhone_number(client.getPhone_number());
        List<Loan> loans = client.getLoans_list();
        List<LoanResponseDto> list = new ArrayList<>();
        //loans.forEach(l -> list.add(LoanMapper.loanToLoanResponseDto(l)));
        for (Loan l : loans){
            LoanResponseDto loanNew = new LoanResponseDto();
            loanNew.setLoan(l.getLoan());
            loanNew.setDate_loan(l.getDate_loan());
            loanNew.setInterest(l.getInterest());
            loanNew.setMonths_debt(l.getMonths_debt());
            loanNew.setDebt_interests_month(l.getDebt_interests_month());
            loanNew.setDebt_total(l.getDebt_total());
            List<PaymentResponseDto> paymentResponseDto = new ArrayList<>();
            List<Payment> listPayment = l.getPayments();
            for(Payment p : listPayment){
                PaymentResponseDto paymentResponse = new PaymentResponseDto();
                paymentResponse.setLocalDateTime(p.getLocalDateTime());
                paymentResponse.setLoan(p.getLoan());
                paymentResponse.setAmount_Payment(p.getAmount_Payment());
                paymentResponse.setDebt_total_actually(p.getDebt_total_actually());
                paymentResponseDto.add(paymentResponse);
            }
            loanNew.setPayments(paymentResponseDto);
            list.add(loanNew);
        }
        clientResponseDto.setLoans_list(list);
        return clientResponseDto;
    }

}
