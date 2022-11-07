package SocialMedia.demo.service.impl;


import org.springframework.stereotype.Service;

import java.util.function.Predicate;
@Service
public class EmailValidatorImpl implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return true;
    }
}
