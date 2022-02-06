package ru.alex.kuznetsov.project.product.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.alex.kuznetsov.project.product.dto.UserRequestDto;
import ru.alex.kuznetsov.project.product.dto.UserResponseDto;
import ru.alex.kuznetsov.project.product.entity.UserEntity;
import ru.alex.kuznetsov.project.product.exception.NoEntityException;
import ru.alex.kuznetsov.project.product.repository.UserRepository;
import ru.alex.kuznetsov.project.product.service.IUserService;
import ru.alex.kuznetsov.project.product.util.CommonMapper;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDto getById(Integer id) {
        logger.debug(String.format("getById - get user with %id", id));
        userRepository.findById(id).orElseThrow(() -> new NoEntityException(String.format("User with ID = %d not found", id)));
        return CommonMapper.fromUserEntityToUserResponseDto(userRepository.getById(id));
    }

    @Override
    public UserResponseDto create(UserRequestDto requestDto){
        logger.debug(String.format("create - create user"));
        UserEntity user = CommonMapper.fromUsersRequestDtoToUsersEntity(requestDto);
        return CommonMapper.fromUserEntityToUserResponseDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto update(UserRequestDto requestDto) {
        UserEntity user = CommonMapper.fromUsersRequestDtoToUsersEntity(requestDto);
        logger.debug(String.format("update - update user with %id", user.getId()));
        return CommonMapper.fromUserEntityToUserResponseDto(userRepository.save(user));
    }

    @Override
    public List<UserResponseDto> getAll() {
        logger.debug(String.format("getAll - retrieve all users"));
        return userRepository.findAll().stream().map(CommonMapper::fromUserEntityToUserResponseDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.findById(id).orElseThrow(() -> {
            logger.debug(String.format("deleteById - User with ID = %d not found", id));
            return new NoEntityException(String.format("User with ID = %d not found", id));
        });
        userRepository.deleteById(id);
    }

    public UserEntity findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public UserEntity findByLoginAndPassword(String login, String password) {
        UserEntity userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
}
