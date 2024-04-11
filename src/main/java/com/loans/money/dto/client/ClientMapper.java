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
        for(Loan l: loans){
            LoanResponseDto loanNew = new LoanResponseDto();
            //loanNew.setClient_data(l.getClient_data());
            loanNew.setLoan(l.getLoan());
            loanNew.setDate_loan(l.getDate_loan());
            loanNew.setInterest(l.getInterest());
            loanNew.setMonths_debt(l.getMonths_debt());
            List<Payment> payment = l.getPayments();
            List<PaymentResponseDto> pdto = new ArrayList<>();
            if(payment!=null){
                for(Payment pay : payment){
                    PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
                    paymentResponseDto.setAmount_Payment(pay.getAmount_Payment());
                    paymentResponseDto.setLocalDateTime(pay.getLocalDateTime());

                    List<BillResponseDto> billResponseDto = new ArrayList<>();
                    for(Bill b : pay.getBill()){
                        billResponseDto.add(BillMapper.billToBillResponseDto(b));
                    }
                    paymentResponseDto.setBill(billResponseDto);
                    pdto.add(paymentResponseDto);
                }
            }else {
                loanNew.setPayments(new ArrayList<>());
            }
            loanNew.setDebt_total(l.getDebt_total());
            loanNew.set_active(l.is_active());
            list.add(loanNew);
        }
        clientResponseDto.setLoans_list(list);
        return clientResponseDto;
    }

}
