package org.flight.planner.flightPnanner.api;

import java.util.List;
import java.util.Optional;

import org.flight.planner.flightPnanner.model.Flight;
import org.flight.planner.flightPnanner.repository.FlightRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@TestConfiguration
public class MyTestConfiguration {
 
    //tests specific beans
    @Bean
    FlightRepository createDataSource(){
    	return new FlightRepository() {

			@Override
			public List<Flight> findAll() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Flight> findAll(Sort sort) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Flight> findAllById(Iterable<String> ids) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <S extends Flight> List<S> saveAll(Iterable<S> entities) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void flush() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public <S extends Flight> S saveAndFlush(S entity) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void deleteInBatch(Iterable<Flight> entities) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void deleteAllInBatch() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public Flight getOne(String id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <S extends Flight> List<S> findAll(Example<S> example) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <S extends Flight> List<S> findAll(Example<S> example, Sort sort) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Page<Flight> findAll(Pageable pageable) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <S extends Flight> S save(S entity) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Optional<Flight> findById(String id) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean existsById(String id) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public long count() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public void deleteById(String id) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void delete(Flight entity) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void deleteAll(Iterable<? extends Flight> entities) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void deleteAll() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public <S extends Flight> Optional<S> findOne(Example<S> example) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <S extends Flight> Page<S> findAll(Example<S> example, Pageable pageable) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <S extends Flight> long count(Example<S> example) {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public <S extends Flight> boolean exists(Example<S> example) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public String findBySunday(String date) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Flight findByDepartureTime(String depertureTime) {
				// TODO Auto-generated method stub
				return null;
			}
    		
    	};
		
		
      
    }
}